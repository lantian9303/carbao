package com.yeww.carbao.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public class Md5Util {

    private final static String charSet = "UTF-8";
    private final static String MD5 = "MD5";

    /**
     * @param saltHead 盐头,可空 UTF-8 编码
     * @param str      需要md5的字符串 UTF-8 编码
     * @param saltTail 盐尾,可空 UTF-8 编码
     * @return 32位MD5小写
     */
    public static String md5Lower32(String saltHead, String str, String saltTail) {
        String result = null;
        try {
            if (saltHead == null) {
                saltHead = "";
            }
            if (saltTail == null) {
                saltTail = "";
            }
            byte[] bytes = new byte[0];
            bytes = (saltHead + str + saltTail).getBytes(charSet);
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(bytes);
            bytes = messageDigest.digest();
            result = ByteUtil.byte2HexLowerCase(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param saltHead 盐头,可空
     * @param str      需要md5的字符串
     * @param saltTail 盐尾,可空
     * @return 32位MD5大写
     */
    public static String md5Upper32(String saltHead, String str, String saltTail) {
        String result = null;
        try {
            if (saltHead == null) {
                saltHead = "";
            }
            if (saltTail == null) {
                saltTail = "";
            }
            byte[] bytes = new byte[0];
            bytes = (saltHead + str + saltTail).getBytes(charSet);
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(bytes);
            bytes = messageDigest.digest();
            result = ByteUtil.byte2HexUpperCase(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "test";
        System.out.println(Md5Util.md5Lower32("", str, "").length());
        System.out.println(Md5Util.md5Lower32("", str, ""));
        System.out.println(Md5Util.md5Upper32("", str, ""));
    }
}
