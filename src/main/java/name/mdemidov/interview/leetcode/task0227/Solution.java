package name.mdemidov.interview.leetcode.task0227;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * 227. Basic Calculator II
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces.
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.replace(" ", "");
        if (s.isEmpty()) {
            return 0;
        }

        int res = 0;
        long prev = 0;
        long cur;
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            cur = 0;
            while (i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                cur *= 10;
                cur += s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                res += prev;
                prev = cur;
            } else if (sign == '-') {
                res += prev;
                prev = -cur;
            } else if (sign == '*') {
                prev *= cur;
            } else if (sign == '/') {
                prev /= cur;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }
        return res + (int) prev;
    }

    public static void main(String[] args) {
        System.out.println(S.calculate("3+2*2")); // 7
        System.out.println(S.calculate(" 3/2 ")); // 1
        System.out.println(S.calculate(" 3+5 / 2 ")); // 5
        System.out.println(S.calculate("1-1+1")); // 1
        System.out.println(S.calculate("2-3+4")); // 3
        System.out.println(S.calculate("0-0")); // 0
        System.out.println(S.calculate("2+3*4")); // 14
    }
}
