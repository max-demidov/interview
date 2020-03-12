package name.mdemidov.interview.leetcode.task0289;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/game-of-life/
 *
 * 289. Game of Life
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell
 * interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four
 * rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current
 * state. The next state is created by applying the above rules simultaneously to every cell in
 * the current state, where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 *
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 */
public class Solution {

    private static final Solution S = new Solution();

    public void gameOfLife(int[][] board) {
        for (int k = -2, i = 0; k < board.length; i++, k++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i < board.length) {
                    board[i][j] += (10 * neighbours(i, j, board));
                }
                if (k < 0) {
                    continue;
                }
                int n = board[k][j] / 10;
                if (n == 3) {
                    board[k][j] = 1;
                } else if (n < 2 || n > 3) {
                    board[k][j] = 0;
                } else {
                    board[k][j] %= 10;
                }
            }
        }
    }

    private static int neighbours(int i, int j, int[][] b) {
        int iMin = i > 0 ? i - 1 : i;
        int iMax = i < b.length - 1 ? i + 1 : i;
        int jMin = j > 0 ? j - 1 : j;
        int jMax = j < b[0].length - 1 ? j + 1 : j;
        int count = 0;
        for (int ii = iMin; ii <= iMax; ii++) {
            for (int jj = jMin; jj <= jMax; jj++) {
                if (ii == i && jj == j) {
                    continue;
                }
                if (b[ii][jj] % 10 > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] b1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        //  [0,0,0],
        //  [1,0,1],
        //  [0,1,1],
        //  [0,1,0]
        S.gameOfLife(b1);
        Stream.of(b1).forEach(r -> System.out.println(Arrays.toString(r)));
        System.out.println();
    }
}
