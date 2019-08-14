package com.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AliUtil {

    public String endpoint;
    public String accessKeyId;
    public String accessKeySecret;
    public String bucketName;


    public AliUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;

    }

    public boolean uploadImage(MultipartFile file) throws IOException {

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        String key = System.currentTimeMillis() + file.getOriginalFilename();
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。

        ossClient.putObject(bucketName, key, new ByteArrayInputStream(file.getBytes()));
        // 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }

    public static boolean transfer() {
// 创建OSSClient实例。
        OSSClient ossClient =
                new OSSClient(
                        "http://oss-cn-beijing.aliyuncs.com",
                        "LTAIbSaoDlE6ln4O",
                        "CT7PvPK34BMtsEAVnt2FBnGzIppMeb");
        // 获取文件列表并将文件下载到本地文件夹中

        // ObjectListing是一个实体类,
        // listObjects是一个返回值为ObjectListing的方法,bucketName作为参数传入,返回对象名(key)
        ObjectListing objectListing = ossClient.listObjects("tasktest");
        // ObjectListing类型的集合list装入bucket里的文件
        List<OSSObjectSummary> list = objectListing.getObjectSummaries();
        // 遍历list,获取所有的key
        for (OSSObjectSummary s : list) {
            String key = s.getKey();
            ossClient.getObject(
                    new GetObjectRequest("tasktest", key), new File("D:/task07.txt"));
        }
        ossClient.shutdown();
        return true;
    }

    public static void main(String[] args) {
        transfer();
    }


}
