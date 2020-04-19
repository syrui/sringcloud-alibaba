package com.syr.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * MD5加密
 * Created by CJP on 2018/4/18.
 */
public class MD5Utils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5Hex(String filename, String[] datas) throws IOException {
        return md5Hex(new File(filename), datas);
    }

    public static String md5Hex(File file, String[] datas) throws IOException {
        MessageDigest digest = DigestUtils.getDigest("md5");
        DigestUtils.updateDigest(digest, new FileInputStream(file));
        if (datas != null) {
            for (String data : datas) {
                DigestUtils.updateDigest(digest, data);
            }
        }
        return Hex.encodeHexString(digest.digest());
    }

    public static String md5Hex(String ... data){
        if(ArrayUtils.isEmpty(data)){
            return null;
        }

        MessageDigest digest = DigestUtils.getMd5Digest();
        for(String str : data){
            DigestUtils.updateDigest(digest, str);
        }

        return byteArrayToHex(digest.digest());
    }

    private static String byteArrayToHex(byte[] byteArray) {
        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] result =new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            result[index++] = hexDigits[b>>> 4 & 0xf];
            result[index++] = hexDigits[b& 0xf];
        }

        // 字符数组组合成字符串返回
        return new String(result);
    }



    /**
     * 按照UTF-8编码对字符串进行加密，如果字符串不是UTF-8编码会抛出异常
     * @param s
     * @return
     */
    public static String getMD5String(String s) {
        try {
            return getMD5String(s.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("MD5加密失败，获取字符串UTF-8字节数组异常：" + ex.getLocalizedMessage());
        }
    }

    /**
     * 按照UTF-8编码对字符串进行加密，如果字符串不是UTF-8编码会抛出异常
     * @param bytes
     * @return
     */
    public static String getMD5String(byte[] bytes) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(bytes);
            return bufferToHex(messagedigest.digest());
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(MD5Utils.class.getName() + "初始化失败，MessageDigest不支持MD5Util。" + ex.getLocalizedMessage());
        }
    }
    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = HEX_DIGITS[(bt & 0xf0) >> 4];
        char c1 = HEX_DIGITS[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    /**
     * 生成用户密码加密盐
     * @param password
     * @return
     */
    public static String genPassword(String password,String salt) {

        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }


    /**
     * 生成密码加密盐
     * @return 密码盐
     */
    public static String genSalt() {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        return sBuilder.toString();
    }
}

