package com.yu.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestNumOfString {

    public static int lengthOfLongestSubstring(String s) {

        int subLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isUnique(s, i, j)) {
                    subLength = Math.max(subLength, j - i + 1);
                }

            }
        }
        return subLength;
    }

    public static int lengthOfLongestSubstrinWindowSlid(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                char ss = s.charAt(i++);
                set.remove(ss);
            }
        }
        return ans;
    }

    private static boolean isUnique(String s, int start, int end) {
        Set<Character> out = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (out.contains(ch)) {
                return false;
            }
            out.add(ch);
        }
        return true;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    private static int slideWindow(String s) {

        int n = s.length();
        HashSet set = new HashSet();
        int ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int output = lengthOfLongestSubstring("dvdf");
//        int output = lengthOfLongestSubstring("asjrgapa");
//        int output = lengthOfLongestSubstrinWindowSlid("abcdabc");
        int output = slideWindow("pwwkew");
//        int output = lengthOfLongestSubstring2("abcda");

        System.out.println(output);
    }
}
