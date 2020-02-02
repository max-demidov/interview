package name.mdemidov.interview.leetcode.task0994;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * 994. Rotting Oranges
 *
 * In a given grid, each cell can have one of three values:
 * - the value 0 representing an empty cell;
 * - the value 1 representing a fresh orange;
 * - the value 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes
 * rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 *
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because
 * rotting only happens 4-directionally.
 *
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int orangesRotting(int[][] grid) {
        int res = 0;
        Grid g = new Grid(grid);
        while (g.fresh > 0) {
            int fresh = g.fresh;
            g.next();
            if (g.fresh == fresh) {
                return -1;
            }
            res++;
        }
        return res;
    }

    private static final class Grid {

        private int[][] grid;
        private int rotten;
        private int fresh;

        private Grid(int[][] grid) {
            this.grid = grid;
            for (int[] row : grid) {
                for (int cell : row) {
                    if (cell == 1) {
                        fresh++;
                    } else if (cell == 2) {
                        rotten++;
                    }
                }
            }
        }

        private void next() {
            Set<Cell> cells = new HashSet<>();
            for (int j = 0; j < grid.length; j++) {
                for (int i = 0; i < grid[j].length; i++) {
                    if (grid[j][i] < 2) {
                        continue;
                    }
                    if (i > 0 && grid[j][i - 1] == 1) {
                        cells.add(new Cell(j, i - 1));
                    }
                    if (i < grid[j].length - 1 && grid[j][i + 1] == 1) {
                        cells.add(new Cell(j, i + 1));
                    }
                    if (j > 0 && grid[j - 1][i] == 1) {
                        cells.add(new Cell(j - 1, i));
                    }
                    if (j < grid.length - 1 && grid[j + 1][i] == 1) {
                        cells.add(new Cell(j + 1, i));
                    }
                }
            }
            for (Cell cell : cells) {
                grid[cell.y][cell.x] = 2;
                rotten++;
                fresh--;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] row : grid) {
                sb.append(Arrays.toString(row)).append("\n");
            }
            return sb.toString();
        }

        private static final class Cell {

            private int y;
            private int x;

            private Cell(int y, int x) {
                this.y = y;
                this.x = x;
            }


            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }

                Cell cell = (Cell) o;

                if (y != cell.y) {
                    return false;
                }
                return x == cell.x;
            }

            @Override
            public int hashCode() {
                int result = y;
                result = 31 * result + x;
                return result;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(S.orangesRotting(grid1)); // 4
        int[][] grid2 = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println(S.orangesRotting(grid2)); // -1
        int[][] grid3 = {
            {0, 2}
        };
        System.out.println(S.orangesRotting(grid3)); // 0
    }
}
