package name.mdemidov.interview.leetcode.task202;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the
 * number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 *
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(7));
    }

    private static int square(int n) {
        return n * n;
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 7) {
            return false;
        }
        int m = 0;
        while (n / 10 > 0) {
            m += square(n % 10);
            n /= 10;
        }
        m += square(n);
        return isHappy(m);
    }

}