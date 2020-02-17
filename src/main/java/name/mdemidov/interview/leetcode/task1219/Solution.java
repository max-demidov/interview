package name.mdemidov.interview.leetcode.task1219;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 *
 * 1219. Path with Maximum Gold
 *
 * In a gold mine grid of size m * n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position you can walk one step to the left, right, up or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 *
 * Example 1:
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 * [5,8,7],
 * [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 *
 * Example 2:
 *
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 * [2,0,6],
 * [3,4,5],
 * [0,3,0],
 * [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                max = Math.max(max, max(grid, y, x));
            }
        }
        return max;
    }

    private static int max(int[][] grid, int y, int x) {
        if (y < 0 || y > grid.length - 1 || x < 0 || x > grid[y].length - 1 || grid[y][x] < 1) {
            return 0;
        }
        int gold = grid[y][x];
        grid[y][x] = 0;
        int max = Math.max(
            Math.max(max(grid, y - 1, x), max(grid, y + 1, x)),
            Math.max(max(grid, y, x - 1), max(grid, y, x + 1))
        );
        grid[y][x] = gold;
        return gold + max;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };
        System.out.println(S.getMaximumGold(grid1)); // 24
        int[][] grid2 = new int[][]{
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
        };
        System.out.println(S.getMaximumGold(grid2)); // 28
        int[][] grid3 = new int[][]{
            {1, 0, 7, 0, 0, 0},
            {2, 0, 6, 0, 1, 0},
            {3, 5, 6, 7, 4, 2},
            {4, 3, 1, 0, 2, 0},
            {3, 0, 5, 0, 20, 0}
        };
        System.out.println(S.getMaximumGold(grid3)); // 60
    }
}
