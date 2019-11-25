package name.mdemidov.interview.leetcode.task029;

/**
 * 29. Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE / -3);
        System.out.println(new Solution().divide(Integer.MIN_VALUE, -3));
    }

    public int divide(int dividend, int divisor) {
        boolean positive = dividend > 0 == divisor > 0;

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            }
            return divide(dividend + Math.abs(divisor), divisor) + (positive ? 1 : -1);
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            res++;
        }
        return positive ? res : -res;
    }

}
