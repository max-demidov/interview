package name.mdemidov.interview.leetcode.task0279;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Solution {

    // n = 4^k * (8m + 7), where k, m are integers

    private static final Solution S = new Solution();

    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        if (isSquare(n)) {
            return 1;
        }
        for (int i = 1, ii; (ii = i * i) < n; i++) {
            if (isSquare(n - ii)) {
                return 2;
            }
        }
        return 3;
    }

    private static boolean isSquare(int n) {
        int nn = (int) Math.sqrt(n);
        return nn * nn == n;
    }

    public static void main(String[] args) {
        System.out.println(S.numSquares(12)); // 3
        System.out.println(S.numSquares(13)); // 2
    }
}
