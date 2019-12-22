package name.mdemidov.interview.leetcode.task062;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) {
            return 1;
        }
        if (m == 2) {
            return n;
        }
        if (n == 2) {
            return m;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

}
