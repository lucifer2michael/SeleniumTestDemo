package com.huait.maven.utils;

import java.util.Random;


public class PhoneNumberUtils {
    private static final String[] PREFIX = {"13", "14", "15", "16", "17", "18", "19"};
    private static final int PHONE_NUMBER_LENGTH = 11;

    public static String getValidPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // 随机生成手机前缀
        int index = random.nextInt(PREFIX.length);
        sb.append(PREFIX[index]);
        // 随机生成剩余的数字
        int randomNumber;
        for (int i = 0; i < PHONE_NUMBER_LENGTH - PREFIX[index].length(); i++) {
            randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }
        return sb.toString();
    }
}

