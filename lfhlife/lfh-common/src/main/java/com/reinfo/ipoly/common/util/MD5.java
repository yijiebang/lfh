package com.reinfo.ipoly.common.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

import sun.misc.BASE64Encoder;

public class MD5 {
    public static String toMD5(String s) {
        return DigestUtils.md5Hex(s);
    }

    public static void main(String[] args) {
    	
    	System.out.println(UUID.randomUUID().toString().split("-").length);
    	System.out.println(generateToken());
    	System.out.println(toMD5("test1234"));
    	
//        System.out.println("7:\t " + toMD5("yu888"));
//        System.out.println("1:\t" + toMD5("1"));
//        System.out.println("123456:\t" + toMD5("123456"));
//        System.out.println(":\t" + toMD5(""));
//        System.out.println("null:\t" + toMD5(null));
//        System.out.println("test1:\t" + toMD5("test1"));
//        System.out.println("test2:\t" + toMD5("test2"));
//        System.out.println("ghccing9119:\t" + toMD5("ghccing9119"));
//        System.out.println("ghccing119:\t" + toMD5("ghccing119"));
    }
    
    
    public static String generateToken(){  
        //通过当前时间毫秒值和随机函数 获取一个随机数  
        String token = System.currentTimeMillis() +new Random(5).nextInt()+"";
        System.out.println(token);
          
        //由于上述获取的随机数长度不定  所以要采用数据摘要类获取固定长度的随机数  MessageDigest  
        try {  
            MessageDigest md = MessageDigest.getInstance("md5");  
            byte[] md5 = md.digest(token.getBytes());  
              
            //又由于md5数组如果转换为字符串基本上会是乱码  所以要用Base64Encoder 来进行转换  成字符串  
            BASE64Encoder encoder = new BASE64Encoder();  
            return encoder.encode(md5);  
              
              
        } catch (NoSuchAlgorithmException e) {  
            throw new RuntimeException();  
        }  
          
          
    }  
    
}
