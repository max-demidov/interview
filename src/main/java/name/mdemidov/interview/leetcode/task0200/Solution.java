package name.mdemidov.interview.leetcode.task0200;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * 200. Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Solution {

    private static final Solution S = new Solution();

    public int numIslands(char[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int sum = 0;
        for (int j = 0; j < grid.length; j++) {
            char[] row = grid[j];
            for (int i = 0; i < row.length; i++) {
                if (visited[j][i]) {
                    continue;
                }
                if (grid[j][i] == '1') {
                    visit(j, i, grid, visited);
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void visit(int j, int i, char[][] grid, boolean[][] visited) {
        if (j < 0 || i < 0 || j >= grid.length || i >= grid[0].length
            || visited[j][i] || grid[j][i] == '0') {
            return;
        }
        visited[j][i] = true;
        visit(j + 1, i, grid, visited);
        visit(j, i + 1, grid, visited);
        visit(j - 1, i, grid, visited);
        visit(j, i - 1, grid, visited);
    }

    public static void main(String[] args) {
        char[][] g1 = {
            "11110".toCharArray(),
            "11010".toCharArray(),
            "11000".toCharArray(),
            "00000".toCharArray()
        };
        System.out.println(S.numIslands(g1)); // 1

        char[][] g2 = {
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
        };
        System.out.println(S.numIslands(g2)); // 3

        char[][] g3 = {
            "111".toCharArray(),
            "010".toCharArray(),
            "111".toCharArray(),
        };
        System.out.println(S.numIslands(g3)); // 1
    }
}
