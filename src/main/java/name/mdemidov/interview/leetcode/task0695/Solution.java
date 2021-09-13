package name.mdemidov.interview.leetcode.task0695;

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
