package com.yu.num;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        if (s.length() == 0 || s.trim().length() == 0 || s.length() == 1) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    ans = sub.length() >= ans.length() ? sub : ans;
                }
            }
        }

        return ans;
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        StringBuilder longest = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            findPalindrome(s, i, i, longest); // odd
            findPalindrome(s, i, i + 1, longest); // even
        }
        return longest.toString();
    }

    private static void findPalindrome(String s, int lo, int hi, StringBuilder longest) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (lo >= 0 && hi < n && s.charAt(lo) == s.charAt(hi)) {
            if (lo == hi) {
                sb.append(s.charAt(lo));
            } else {
                sb.insert(0, s.charAt(lo));
                sb.append(s.charAt(hi));
            }
            --lo;
            ++hi;
        }
        if (sb.length() > longest.length()) {
            longest.delete(0, longest.length());
            longest.append(sb);
        }
    }

    public static boolean isPalindrome(String sub) {

        int n = sub.length();

        int i = 0;

        while (i < n / 2) {
            if (sub.charAt(i) == sub.charAt(n - 1 - i)) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * by self
     *
     * @param s
     * @return
     */
    private static String longestPalindromeSelf(String s) {

        int n = s.length();

        if (n == 0) {
            return "";
        }
        StringBuilder longest = new StringBuilder();
        for (int i = 0; i < n; i++) {
            findLongestByExtendFromCenter(s, i, i, longest);
            findLongestByExtendFromCenter(s, i, i + 1, longest);
        }

        return longest.toString();
    }

    private static void findLongestByExtendFromCenter(String s, int low, int high, StringBuilder longest) {

        StringBuilder sb = new StringBuilder();
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            if (low == high) {
                sb.append(s.charAt(low));
            } else {
                sb.insert(0, s.charAt(low));
                sb.append(s.charAt(high));
            }

            low--;
            high++;
        }

        if (sb.length() >= longest.length()) {
            longest.setLength(0);
            longest.append(sb);
        }
    }

    public static String longestPalindrome4(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = generateDP(s);
        // Check each substring
        int maxLen = 0;
        int[] maxIdx = new int[]{0, 0};
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (dp[i][j] == true) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxIdx[0] = i;
                        maxIdx[1] = j;
                    }
                }
            }
        }
        return s.substring(maxIdx[0], maxIdx[1] + 1);
    }

    private static boolean[][] generateDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // Init
        for (int i = 0; i < n; ++i) { // diagonal
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; ++i) { // one line below diagonal
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        // DP
        for (int i = n - 3; i >= 0; --i) {
            for (int j = i + 2; j < n; ++j) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return dp;
    }

    private static String longestPalindrome5(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int low = 0;
        int high = 0;

        int maxLen = 0;
        boolean[][] bp = generateDPArray(s);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (bp[i][j]) {
                    if (maxLen <= (j - i + 1)) {
                        maxLen = j - i + 1;
                        low = i;
                        high = j;
                    }

                }
            }
        }
        return s.substring(low, high + 1);
    }


    public static String convert(String s, int numRows) {

        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();

        StringBuilder sb = new StringBuilder(s);
        int len = 2 * numRows - 2;
        String[][] output = new String[numRows][numRows];
        int i = 0;
        while (sb.length() > 0) {
            String str = s.substring(0, len);

            output[0][i] = str.substring(0, 1);

            int ll = len - 1;
            for (int j = 1; j < ((ll % 2 == 0) ? (ll / 2) + 1 : (ll / 2 + 2)); j++) {
                if (ll - j == j) {
                    output[j][i] = str.substring(j, j + 1);
                } else {
                    output[j][i] = str.substring(j, j + 1) + str.substring(ll - j, ll - j + 1);
                }
            }

            sb.delete(0, len);
            i++;
        }
        for (int k = 0; k < numRows; k++) {
            for (int j = 0; j < numRows; j++) {
                if (output[k][j].length() > 0) {
                    res.append(output[k][j]);
                }
            }
        }

        return res.toString();


    }

    private static boolean[][] generateDPArray(String s) {

        int n = s.length();
        boolean[][] bp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            bp[i][i] = true;
            if (i + 1 < n) {
                bp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        for (int j = 2; j < n; j++) {
            for (int i = 0; i <= j - 2; i++) {
                bp[i][j] = bp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        return bp;
    }


    public static void main(String[] args) {
//        String sub = longestPalindrome("babad");
//        String sub = longestPalindrome2("aabad");
//        String sub = longestPalindromeSelf("aabad");
//        String sub = longestPalindrome5("aabad");
        String xx = convert("PAYPALISHIRING", 4);
        System.out.println(xx);
    }
}
