package name.mdemidov.interview.leetcode.task0695;

/**
 * https://leetcode.com/problems/max-area-of-island/
 *
 * <p>695. Max Area of Island
 *
 * <p>You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water.
 *
 * <p>The area of an island is the number of cells with a value 1 in the island.
 *
 * <p>Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * <p>Example 1:
 *
 * <p>Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0], [0,1,0,0,1,1,0,0,1,0,1,0,0], [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0], [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * <p>Output: 6
 *
 * <p>Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 * <p>Example 2:
 *
 * <p>Input: grid = [[0,0,0,0,0,0,0,0]]
 *
 * <p>Output: 0
 *
 * <p>Constraints:
 *
 * <p>m == grid.length
 *
 * <p>n == grid[i].length
 *
 * <p>1 <= m, n <= 50
 *
 * <p>grid[i][j] is either 0 or 1.
 */
public class Solution {

  private int[][] g;

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    g = grid;
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[0].length; x++) {
        max = Math.max(max, area(y, x));
      }
    }
    return max;
  }

  private int area(int y, int x) {
    if (y < 0 || x < 0 || y >= g.length || x >= g[0].length || g[y][x] < 1) {
      return 0;
    }
    g[y][x]--;
    return 1 + area(y + 1, x) + area(y - 1, x) + area(y, x + 1) + area(y, x - 1);
  }

  public static void main(String[] args) {
    int[][] grid = {
      {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    System.out.println(new Solution().maxAreaOfIsland(grid));
  }
}
