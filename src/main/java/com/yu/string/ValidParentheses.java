package com.yu.string;

import java.util.*;

/**
 *  Valid Parentheses(有效的括号)
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        Map<Character,Character> characters =new HashMap<>();
        characters.put('(',')');
        characters.put('{','}');
        characters.put('[',']');
        boolean isFlag = false;
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return isFlag;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chars.length; i++) {

            if (characters.keySet().contains(chars[i])){
                st.push(chars[i]);
            }else {
                if (st.empty()  || characters.get(st.pop()) != chars[i])
                    return isFlag;
            }
        }
        if (!st.isEmpty()){
            return isFlag;
        }
        return true;
    }

    public static void main(String[] args) {
       boolean result = ValidParentheses.isValid("((");
        System.out.println(result);
    }
}
