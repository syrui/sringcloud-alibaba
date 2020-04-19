package com.gmall.fastdfs.util;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * @program: com-around-project
 * @description: fds文件操作工具类
 * @author: moodincode
 * @create: 2019/12/16
 **/
@Component
public class FileDfsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileDfsUtil.class);
    @Resource
    private FastFileStorageClient storageClient ;
    /**
     * 上传文件
     */
    public String uploadImage(InputStream fileInputStream,long size,String fileExtName, Set<MetaData> metaDataSet) throws Exception{
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(fileInputStream,size,fileExtName , metaDataSet);
        return storePath.getFullPath() ;
    }
    /**
     * 上传文件
     */
    public String uploadFile(InputStream fileInputStream,long size,String fileExtName, Set<MetaData> metaDataSet) throws Exception{
        StorePath storePath = this.storageClient.uploadFile(fileInputStream,size,fileExtName , metaDataSet);
        return storePath.getFullPath() ;
    }
    /**
     * 删除文件
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            LOGGER.info("fileUrl == >>文件路径为空...");
            return;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

    public byte[] downloadFile(String fileUrl) throws IOException {
        StorePath storePath = StorePath.parseFromUrl(fileUrl);
        DownloadByteArray downloadByteArray = new DownloadByteArray();
        byte[] bytes = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), downloadByteArray);
        return bytes;
    }

}