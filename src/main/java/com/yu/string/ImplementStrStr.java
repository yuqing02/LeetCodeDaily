package com.yu.string;

public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {

        char[] chars = needle.toCharArray();

//        for (int i = 0; i < chars.length; i++) {
//            char cc = chars[i];
//            String[] result = haystack.split(cc + "");
//            if (result.length>1){
//                return result[0].length();
//            }
//        }

        int i = haystack.indexOf(needle);
        return i;
//        if (needle.length() == 0 || haystack.equals(needle)) {
//            return 0;
//        }
//
//        if (haystack.length() == 0){
//            return  -1;
//        }
//        String[] result = haystack.split(needle);
//
//        if (result.length == 0){
//            return 0;
//        }else if (result.length >=1){
//            if (result[0].length() == haystack.length()){
//                return -1;
//            }else {
//                return result[0].length();
//            }
//        }else {
//            return -1;
//        }
    }

    public static void main(String[] args) {

//        int len = strStr("a", "a");
//        int len = strStr("aaaa", "a");
//        int len = strStr("abbb", "a");
//        int len = strStr("abbb", "ab");
//        int len = strStr("abbb", "");
        int len = strStr("abbb", "c");
//        int len = strStr("abbbpi", "pi");

        System.out.println(len);
    }
}
