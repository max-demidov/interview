package name.mdemidov.interview.leetcode.task0329;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * <p>329. Longest Increasing Path in a Matrix
 *
 * <p>Given an integer matrix, find the length of the longest increasing path.
 *
 * <p>From each cell, you can either move to four directions: left, right, up or down. You may NOT
 * move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * <p>Example 1:
 *
 * <pre>
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * </pre>
 *
 * <p>Example 2:
 *
 * <pre>
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * </pre>
 */
public class Solution {
  private static final Solution S = new Solution();

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length < 1) {
      return 0;
    }
    int[][] memo = new int[matrix.length][matrix[0].length];
    int max = 0;
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        max = Math.max(max, longest(matrix, y, x, Integer.MIN_VALUE, memo));
      }
    }
    return max;
  }

  private static int longest(int[][] matrix, int y, int x, int prev, int[][] memo) {
    if (y < 0
        || x < 0
        || y > matrix.length - 1
        || x > matrix[0].length - 1
        || matrix[y][x] <= prev) {
      return 0;
    }
    if (memo[y][x] < 1) {
      memo[y][x] =
          1
              + Math.max(
                  Math.max(
                      longest(matrix, y + 1, x, matrix[y][x], memo),
                      longest(matrix, y - 1, x, matrix[y][x], memo)),
                  Math.max(
                      longest(matrix, y, x + 1, matrix[y][x], memo),
                      longest(matrix, y, x - 1, matrix[y][x], memo)));
    }
    return memo[y][x];
  }

  public static void main(String[] args) {
    System.out.println(
        S.longestIncreasingPath(
            new int[][] {
              {9, 9, 4},
              {6, 6, 8},
              {2, 1, 1}
            })); // 4

    System.out.println(
        S.longestIncreasingPath(
            new int[][] {
              {3, 4, 5},
              {3, 2, 6},
              {2, 2, 1}
            })); // 4

    System.out.println(S.longestIncreasingPath(new int[][] {})); // 0
  }
}
