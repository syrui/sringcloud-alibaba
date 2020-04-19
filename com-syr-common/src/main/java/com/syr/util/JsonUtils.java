package com.syr.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxd on 2017/11/27.
 * json对象公具类
 */
public class JsonUtils {
    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * 将一个对象转成json字符串
     * @param instance
     * @return
     */
    public static String toJsonString(Object instance){
        try {
            return mapper.writeValueAsString(instance);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转成对象
     * @param jsonString
     * @param type
     * @param <T>
     * @return
     */
    public static  <T> T toBean(String jsonString,Class<T> type){
        try {
            return mapper.readValue(jsonString, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否是json格式字符串
     * @param str 待判断的字符串
     * @return 判断结果
     */
    public static boolean isJsonStr(String str) {
        try {
            JSONObject jsonStr = JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 将下划线转换为驼峰的形式，例如：user_name-->userName
     * 注意：字段类型一定要匹配
     */
    public static <T> T toSnakeBean(String jsonString, Class<T> clazz) {
        try {
            // mapper的configure方法可以设置多种配置（例如：多字段 少字段的处理）
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * JSON 字符串转集合
     * @param jsonString        JSON 字符串
     * @param collectionClass   集合类型
     * @param elementClasses    集合元素类型
     * @param <T>               返回集合
     * @return
     */
    public static <T> T toCollection(String jsonString, Class<?> collectionClass, Class<?>... elementClasses){
        try {
            return mapper.readValue(jsonString, getCollectionType(collectionClass, elementClasses));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * JSON 字符串转Map集合
     * @param jsonStr   JSON 字符串
     * @return map集合
     */
    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        if(StringUtils.isNotBlank(jsonStr) && jsonStr.startsWith("{") && jsonStr.endsWith("}")){
            Map<String, Object> map = new HashMap<>();

            JSONObject json = JSONObject.parseObject(jsonStr);
            for (Object obj : json.keySet()){
                Object v = json.get(obj);

                // 字段值为null直接转为空
                if (null == v) {
                    map.put(obj.toString(), "");
                }else if(v instanceof JSONArray){
                    List<Map<String, Object>> list = new ArrayList<>();
                    for (Object o : (JSONArray) v) {
                        JSONObject json2 = (JSONObject) o;
                        list.add(parseJSON2Map(json2.toString()));
                    }
                    map.put(obj.toString(), list);
                }else{
                    Map<String, Object> m = parseJSON2Map(v.toString());
                    if ( null == m ){
                        map.put(obj.toString(), v);
                    }else {
                        map.put(obj.toString(), m);
                    }
                }
            }
            return map;
        }else {
            return null;
        }
    }

}
