package com.yu.num;

import com.sun.tools.hat.internal.model.AbstractJavaHeapObjectVisitor;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    public static int romanToInt(String s) {
        String[] special_random = {"IV", "IX", "XL", "XC", "CD", "CM"};
        Map<String, Integer> maps = new HashMap<String, Integer>();
        if (s.length() == 0 || s.equals(""))
            return 0;
        //cm 等的数量
        for (String s1 : special_random) {
            int ori_num = s.length();
            s = s.replaceAll(s1, "");
            int nums = (ori_num - s.length()) / 2;
            if (nums > 0) {
                maps.put(s1, nums);
            }
        }

        //剩余的字符数量
        for (int i = 0; i < s.length(); i++) {
            String random = String.valueOf(s.charAt(i));
            if (maps.containsKey(random)) {
                Integer fre = maps.get(random);
                maps.put(random, ++fre);
            } else {
                maps.put(random, 1);
            }
        }

        //计算对应的字符串和对应的个数的总值
        int total = 0;
        for (String key : maps.keySet()) {
            int size = getNumByRandom(key);
            int num = maps.get(key);
            total += num * size;
        }

        return total;
    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param random
     * @return
     */
    private static int getNumByRandom(String random) {
        switch (random) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        int total = romanToInt("MMMXLV");
        System.out.println(total);
    }
}
