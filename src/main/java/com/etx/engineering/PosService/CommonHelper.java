package com.etx.engineering.PosService;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class CommonHelper {
    public static String generateRandomSecurePassword() {
        char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?")).toCharArray();
        String randomStr = RandomStringUtils.random( 10, 0, possibleCharacters.length-1, false, false, possibleCharacters, new SecureRandom() );
        return randomStr;
    }
}
