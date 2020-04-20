package name.mdemidov.interview.leetcode.task0050;

/**
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 10)); // 1024.0
        System.out.println(new Solution().myPow(2.1, 3)); // 9.261
        System.out.println(new Solution().myPow(2, -2)); // 0.25
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / (myPow(x, -n - 1) * x);
        }
        double res = myPow(x, n / 2);
        res *= res;
        if (n % 2 > 0) {
            res *= x;
        }
        return res;
    }

}
