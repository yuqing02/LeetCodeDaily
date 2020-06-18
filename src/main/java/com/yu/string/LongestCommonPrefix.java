package com.yu.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char random = firstStr.charAt(i);
            boolean flagBreak = false;
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if ((i + 1) > str.length()) {
                    flagBreak = true;
                    break;
                }
                char randomOther = str.charAt(i);
                if (randomOther != random) {
                    flagBreak = true;
                    break;
                }
            }
            if (flagBreak) {
                break;
            }
            builder.append(String.valueOf(random));
        }

        return builder.toString();
    }

//    Approach 1: Horizontal scanning
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        if (prefix.isEmpty()) return "";



        return prefix;
    }

    public static void main(String[] args) {
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {"flower", "flow", "flight"};
//        String prefix = longestCommonPrefix(strs);
        String prefix = longestCommonPrefix2(strs);
        System.out.println(prefix);
    }
}
