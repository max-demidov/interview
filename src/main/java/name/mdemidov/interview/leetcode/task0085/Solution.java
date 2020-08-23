package name.mdemidov.interview.leetcode.task0085;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * <p>
 * 85. Maximal Rectangle
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's
 * and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <pre>
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * </pre>
 * Output: 6
 */
public class Solution {

  private static final Solution S = new Solution();

  public int maximalRectangle(char[][] matrix) {
    int yMax = matrix.length;
    if (yMax < 1) {
      return 0;
    }
    int xMax = matrix[0].length;
    int[][] dp = new int[yMax][xMax];
    int area = 0;
    for (int y = 0; y < yMax; y++) {
      for (int x = 0; x < xMax; x++) {
        if (matrix[y][x] == '1') {
          dp[y][x] = x > 0 ? dp[y][x - 1] + 1 : 1;
          int width = dp[y][x];
          for (int yy = y; yy >= 0; yy--) {
            width = Math.min(width, dp[yy][x]);
            area = Math.max(area, width * (y - yy + 1));
          }
        }
      }
    }
    return area;
  }

  public static void main(String[] args) {
    char[][] m1 = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };
    System.out.println(S.maximalRectangle(m1)); // 6
    char[][] m2 = new char[][]{
        {'1', '0'},
        {'1', '0'}
    };
    System.out.println(S.maximalRectangle(m2)); // 2
  }
}
