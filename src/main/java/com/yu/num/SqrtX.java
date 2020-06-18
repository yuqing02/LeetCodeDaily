package com.yu.num;

public class SqrtX {

    //Math
    public static int mySqrt(int x) {

        return mySqrt2(x, 0, x);

    }

    //循环（难
    public static int mySqrt3(int x) {
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 + 1;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return hi;

    }

    //递归
    private static int mySqrt2(int x, int l, int h) {
        if (h - l <= 1) {
            if (x < l * l) {
                return l - 1;
            } else if (x >= h * h) {
                return h;
            } else {
                //  h*h > x >= l*l
                return l;
            }
        }
        int mid = l + ((h - l) >> 1);
        if (mid == x / mid) return mid;
        if (mid > x / mid) {
            return mySqrt2(x, l, mid - 1);
        } else {
            return mySqrt2(x, mid, h);
        }
    }

    public static void main(String[] args) {
//        int result = mySqrt(4);
//        int result = mySqrt(8);
        int result = mySqrt3(5);

        System.out.println(result);
    }
}
