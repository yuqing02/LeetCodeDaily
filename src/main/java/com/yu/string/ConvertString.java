package com.yu.string;

public class ConvertString {

    public static String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        char[] chs = s.toCharArray();

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int step = 1;
        int row = 0;
        for (char ch : chs) {
            sbs[row].append(ch);

            if (row == 0) {
                step = 1;
            } else if (row + 1 == numRows) {
                step = -1;
            }

            row += step;
        }
        StringBuilder output = new StringBuilder();
        for (StringBuilder sb : sbs) {
            output.append(sb);
        }

        return output.toString();
    }

    public static String convert4(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= numRows; row++) {
            int index = row - 1;
            boolean isUp = true;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                if (row == 1 || row == numRows) {
                    index += 2 * numRows - 2;
                } else {
                    index += isUp ? 2 * (numRows - row) : 2 * (row - 1);
                    isUp = !isUp;
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
//        String xx = convert2("PAYPALISHIRING", 3);
//        String xx = convert4("PAYPALISHIRING", 4);
        String xx = convert4("AB", 1);
        System.out.println(xx);
    }
}
