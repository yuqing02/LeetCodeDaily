package com.yu.string;

public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        if (s.trim().length() == 0){
            return 0;
        }
        String[] result = s.split(" ");

        return result[result.length-1].length();

    }

    public static void main(String[] args) {
        int lenfth = lengthOfLastWord("Hello World");

        System.out.println(lenfth);
    }

}
