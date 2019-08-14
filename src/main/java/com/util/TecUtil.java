package com.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

import java.io.File;

public class TecUtil {

    public static void main(String[] args) {
// 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDrb8VgbIG3mKBeuJn492f5SdaHk28nh6H";
        String secretKey = "rdXGBvQs42H1d4LLBoNxNabQL2g8PTNT";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        System.out.println("看到这一步说明上面没问题");

        String bucket = "testtask-1258979179";

        File localFile = new File("D:/task07.txt");

        String key = "testdemo.png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, localFile);
        System.out.println("创建的对象是:"+putObjectRequest);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println("创建的对象是:"+putObjectResult);

        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();

    }
}