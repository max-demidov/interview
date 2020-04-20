package name.mdemidov.interview.leetcode.task0172;

import java.math.BigInteger;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Note: Your solution should be in logarithmic time complexity.
 */
public class Solution {

    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            System.out.println(
                String.format("#%d - act zeroes %d - exp zeroes %d", i, actZeroes(factorial(i)),
                              new Solution().trailingZeroes(i)));
        }
    }

    private static int d(int source, int base) {
        int d = source / base;
        return d < 5 ? d : d + d(source, base * 5);
    }

    private static int actZeroes(BigInteger n) {
        int res = 0;
        String s = n.toString();
        while (s.charAt(s.length() - res - 1) == '0') {
            res++;
        }
        return res;
    }

    private static BigInteger factorial(int n) {
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    public int trailingZeroes(int n) {
        return d(n, 5);
    }
}
