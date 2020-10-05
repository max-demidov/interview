package name.mdemidov.interview.leetcode.task0064;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * <p>64. Minimum Path Sum
 *
 * <p>Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * <p>Note: You can only move either down or right at any point in time.
 *
 * <p>Example:
 *
 * <p>Input:
 *
 * <pre>
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * </pre>
 *
 * Output: 7
 *
 * <p>Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Solution {
  private static final Solution S = new Solution();

  public int minPathSum(int[][] grid) {
    return min(grid, 0, 0, new int[grid.length][grid[0].length]);
  }

  private static int min(int[][] grid, int y, int x, int[][] sums) {
    if (y > grid.length - 1 || x > grid[0].length - 1) {
      return Integer.MAX_VALUE;
    }
    if (y == grid.length - 1 && x == grid[0].length - 1) {
      return grid[y][x];
    }
    if (sums[y][x] < 1) {
      sums[y][x] = grid[y][x] + Math.min(min(grid, y + 1, x, sums), min(grid, y, x + 1, sums));
    }
    return sums[y][x];
  }

  public static void main(String[] args) {
    System.out.println(S.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}})); // 7
  }
}
