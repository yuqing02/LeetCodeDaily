package com.yu.num;

public class AddBinary {

    private static String zero(String str, int len) {

        StringBuilder builder = new StringBuilder();

        while (len > 0) {
            builder.append("0");
            len--;
        }
        return builder.toString() + str;
    }

    public static String addBinary(String a, String b) {


//        int subLen = Math.abs(a.length() > b.length() ? a.length() : b.length());
//        String format = "%0" + subLen + "d";
//        if (subLen > 0 && (a.length() > b.length())) {
////            b = String.format(format, new Long(b));
//            b = zero(b, a.length() - b.length());
//        } else if (subLen > 0 && (a.length() < b.length())) {
////            a = String.format(format, new Long(a));
//            a = zero(a, b.length() -a.length());
//        }


        String before = "";
        StringBuilder stringBuilder = new StringBuilder();
        //补位 a.len=b.len ()
        //假定 len不一致，思路：小的len为止
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean flag = false;
        while (i >= 0 || j >= 0) {
            int A = i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
            int B = j >= 0 ? Integer.parseInt(String.valueOf(b.charAt(j))) : 0;


            if (!flag && (i < 0 || j < 0)) {
                before = i < 0 ? b.substring(0, j + 1) : a.substring(0, i + 1);
                break;
            }

            stringBuilder.append((A + B + (flag ? 1 : 0)) % 2);

            flag = (A + B + (flag ? 1 : 0)) >= 2;

            i--;
            j--;
        }

        if (flag) {
            stringBuilder.append(1);
        }
        return before + stringBuilder.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        //补位 a.len=b.len ()
        //假定 len不一致，思路：小的len为止
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean flag = false;
        while ((i > j ? i >= 0 : j >= 0)) {
            int A = i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
            int B = j >= 0 ? Integer.parseInt(String.valueOf(b.charAt(j))) : 0;

            stringBuilder.append((A + B + (flag ? 1 : 0)) % 2);
            flag = (A + B + (flag ? 1 : 0)) >= 2;
            i--;
            j--;
        }

        if (flag) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }
    public static void main(String[] args) {
//        String result = "11";
//        String format = "%02d";
//        String ss = String.format(format, 11);

        String result = addBinary("10000111111111", "1011");

        System.out.println(result);
//        System.out.println(ss);
    }
}
