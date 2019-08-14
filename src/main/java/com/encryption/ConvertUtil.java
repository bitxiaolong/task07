package com.encryption;



/**转换工具*/

public class ConvertUtil {



    /**将byte数组转换为表示16进制值的字符串，如将byte[]{8,18}转换为：{08,13}

     * 本方法与public static byte[] hexStrToByArr(String strIn)互为可逆的转换过程

     * @param arrB 需要转换的数组

     * @return 转换后的字符串*/

    public static String byteArrToHexStr(byte[] arrB){

        int len = arrB.length;

        //每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍

        StringBuffer stringBuffer = new StringBuffer(len*2);

        for (byte anArrB : arrB){

            int intTmp = anArrB;

            while (intTmp < 0){

                //把负数转换为正数

                intTmp = intTmp+256;

            }

            if (intTmp < 16){

                //小于0F的数需要在前面补0

                stringBuffer.append("0");

            }

            stringBuffer.append(Integer.toString(intTmp,16));

        }

        return stringBuffer.toString();

    }



    /**

     * 将表示16进制值的字符串转换为byte数组

     * 本方法与public static String byteArrToHexStr(byte[] arrB)互为可逆的转换过程

     * @param strIn 需要转换的字符串

     * @return 转换后的byte数组*/

    public static byte[] hexStrToByteArr(String strIn){

        byte[] arrB = strIn.getBytes();

        int len = arrB.length;

        //两个(16进制)字符表示一个字节(8位)，所以字节数组长度是字符串长度除2

        byte[] arrOut = new byte[len/2];

        for (int i = 0; i < len; i= i+2){

            String strTmp = new String(arrB,i,2);

            arrOut[i/2] = (byte) Integer.parseInt(strTmp,16);

        }

        return arrOut;

    }

}