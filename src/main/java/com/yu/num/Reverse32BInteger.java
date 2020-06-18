package com.yu.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//123->321,120->21,1200->21
//!!!! 964632435 * 10 +1=1056389759 这个是怎么算出了的？这明显是超过int32位的范围，所以结果会是一个随机数
public class Reverse32BInteger {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if ((rev > Integer.MAX_VALUE / 10) || ((rev == Integer.MAX_VALUE / 10) && (pop > Integer.MAX_VALUE%10))) {
                return 0;
            }
            if ((rev < Integer.MIN_VALUE / 10) || ((rev == Integer.MIN_VALUE / 10) && (pop < Integer.MIN_VALUE%10))) {
                return 0;
            }
            rev = rev * 10 + pop;

        }
        return (int) rev;
    }

    public static void main(String[] args) {
        int xx = reverse(1534236469);
        System.out.println(xx);
    }


}
