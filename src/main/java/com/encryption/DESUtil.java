package com.encryption;



import org.springframework.stereotype.Component;



import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;



import javax.crypto.Cipher;

import java.security.Key;

import java.security.Security;



/**

 * DES 加密工具类*/

@Component

public class DESUtil {



    Logger logger = LogManager.getLogger(DESUtil.class);

    //定义加密类型

    private static final String ENCRYPT_TYPE = "DES";

    //字符串默认键值

    private static String defaultKey = "";

    //Cipher类为加密和解密提供密码功能。

    //加密工具

    private Cipher encryptCipher;

    //解密工具

    private Cipher decryptCipher;



    /**

     * 构造方法*/

    public DESUtil()throws Exception{

        this(defaultKey);

    }

    /**

     * 指定密钥构造方法

     * @param stringKey 指定密钥*/

    public DESUtil(String stringKey)throws Exception{

        //java.security：Java中为安全框架提供类和接口

        //Security.addProvider(Provider provider)：将提供者添加到下一个可用位置

        Security.addProvider(new com.sun.crypto.provider.SunJCE());

        //生成密钥 getBytes()将字符串变成一个byte数组

        Key key = getKey(stringKey.getBytes());

        //getInstance得到加密对象

        encryptCipher = Cipher.getInstance(ENCRYPT_TYPE);

        //初始化加密对象，当Cipher对象被初始化时，它将失去以前得到的所有状态。

        encryptCipher.init(Cipher.ENCRYPT_MODE, key);

        //getInstance获取解密对象

        decryptCipher = Cipher.getInstance(ENCRYPT_TYPE);

        //初始化解密对象

        decryptCipher.init(Cipher.DECRYPT_MODE, key);

    }



    /**

     * 从指定字符串生成密钥，密钥所需的字节数组长度为8位，不足8位时后面补0，超出8位只取8位

     * @param arrBTmp 构成该字符串的字节数组

     * @return 生成的密钥*/

    private Key getKey(byte[] arrBTmp) {

        //创建一个空的8位字节数组(默认为0)

        byte[] arrB = new byte[8];

        //将原始字节数组转换为8位

        for (int i = 0; i < arrBTmp.length && i <arrB.length; i++){

            arrB[i] = arrBTmp[i];

        }

        return new javax.crypto.spec.SecretKeySpec(arrB,ENCRYPT_TYPE);

    }



    /**

     * 加密字节数组

     * @param arr 需加密的字节数组

     * @return 加密后的字节数组

     * @throws Exception*/

    private byte[] encryptStr(byte[] arr)throws Exception{

        return encryptCipher.doFinal(arr);

    }

    /**

     * 解密字节数组

     * @param arr 需解密的字节数组

     * @return 解密后的字节数组

     * @throws Exception*/

    private byte[] decryptStr(byte[] arr)throws Exception{

        return decryptCipher.doFinal(arr);

    }



    /**

     * 加密字符串

     *

     * @param strIn 需加密的字符串

     * @return 加密后的字符串

     * @throws Exception*/

    public String encrypt(String strIn)throws Exception{

        return ConvertUtil.byteArrToHexStr(encryptStr(strIn.getBytes()));

    }



    /**

     * 解密字符串

     * @param strIn 需解密的字符串

     * @return 解密后的字符串

     * @throws Exception*/

    public String decrypt(String strIn)throws Exception{

        String token = new String(decryptStr(ConvertUtil.hexStrToByteArr(strIn)));

        return token;

    }





}