package name.mdemidov.interview.leetcode.task0348;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 *
 * 348. Design Tic-Tac-Toe
 *
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical,
 * or diagonal row wins the game.
 *
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 *
 * TicTacToe toe = new TicTacToe(3);
 *
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 *
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 *
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 *
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 *
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 *
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 *
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 *
 * Follow up:
 * Could you do better than O(n^2) per move() operation?
 */
public class TicTacToe {

    private int[][] grid;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        grid = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int winner = 0;
        grid[row][col] = player;
//        for (int[] r : grid) {
//            System.out.println(Arrays.toString(r));
//        }
//        System.out.printf("toe.move(%d, %d, %d) = ", row, col, player);

        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != player) {
                winner = 0;
                break;
            }
            winner = player;
        }
        if (winner > 0) {
            return winner;
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] != player) {
                winner = 0;
                break;
            }
            winner = player;
        }
        if (winner > 0) {
            return winner;
        }

        if (col != row && col != grid.length - row - 1) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != player) {
                winner = 0;
                break;
            }
            winner = player;
        }
        if (winner > 0) {
            return winner;
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid.length - i - 1] != player) {
                winner = 0;
                break;
            }
            winner = player;
        }
        return winner;
    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        toe.move(0, 0, 1);
        toe.move(0, 2, 2);
        toe.move(2, 2, 1);
        toe.move(1, 1, 2);
        toe.move(2, 0, 1);
        toe.move(1, 0, 2);
        System.out.println(toe.move(2, 1, 1)); // 1

        TicTacToe toe1 = new TicTacToe(2);
        toe1.move(0, 1, 1);
        toe1.move(1, 1, 2);
        System.out.println(toe1.move(1, 0, 1)); // 1

        TicTacToe toe2 = new TicTacToe(3);
        toe2.move(0, 0, 2);
        toe2.move(2, 0, 2);
        System.out.println(toe2.move(1, 0, 2)); // 2
    }
}
