package com.huait.maven.utils;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

//		生成指定范围内的整数
//
//		@param min 最小值（包含）
//		@param max 最大值（包含)
//	    @return随机整数

    public static int randomInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

//		生成指定长度的随机字符串（由数字和大小写字母组成）
//
//		@param length 字符串长度
//
//		@return随机字符

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int type = randomInt(1, 3);
            switch (type) {
                case 1:
                    sb.append(randomInt(0, 9));
                    break;
                case 2:
                    sb.append((char) randomInt('a', 'z'));
                    break;
                case 3:
                    sb.append((char) randomInt('A', 'Z'));
                    break;
            }
        }
        return sb.toString();
    }
}

