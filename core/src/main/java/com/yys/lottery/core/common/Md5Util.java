package com.yys.lottery.core.common;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Util {

    public static String md5(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("Md5");
            digest.update(str.getBytes("utf-8"));
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("MD5签名过程中出现错误");
        }
    }

    public static String md5Up(String str){
        try {
            return  DigestUtils.md5Hex(str.getBytes("UTF-8")).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误");
        }
    }
}
