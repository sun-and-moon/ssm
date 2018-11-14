package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();

    public static String encoderPassword(String password){
        String encodepassword = bpe.encode(password);
        return encodepassword;
    }

    public static void main(String[] args) {
        System.out.println(encoderPassword("bbb"));
        //$2a$10$/UdTYdBoDJH3KtnVxHG9kujbWEiSdgTGF.vbTiSqYBSF/7ZeKQKXq
    }
}
