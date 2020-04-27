package name.mdemidov.interview.leetcode.task0130;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
 * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an
 * 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
 * connected horizontally or vertically.
 */
public class Solution {

    private static final Solution S = new Solution();

    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int y = 1; y < board.length - 1; y++) {
            if (board[y][0] == 'O') {
                capture(y, 1, board, visited);
            }
            if (board[y][board[0].length - 1] == 'O') {
                capture(y, board[0].length - 2, board, visited);
            }
        }
        for (int x = 1; x < board[0].length - 1; x++) {
            if (board[0][x] == 'O') {
                capture(1, x, board, visited);
            }
            if (board[board.length - 1][x] == 'O') {
                capture(board.length - 2, x, board, visited);
            }
        }
        for (int y = 1; y < board.length - 1; y++) {
            for (int x = 1; x < board[0].length - 1; x++) {
                if (board[y][x] == 'O' && !visited[y][x]) {
                    board[y][x] = 'X';
                }
            }
        }
    }

    private static void capture(int y, int x, char[][] board, boolean[][] visited) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[0].length
            || visited[y][x] || board[y][x] == 'X') {
            return;
        }
        visited[y][x] = true;
        capture(y - 1, x, board, visited);
        capture(y + 1, x, board, visited);
        capture(y, x - 1, board, visited);
        capture(y, x + 1, board, visited);
    }

    private static void print(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        char[][] b1 = {
            {'X', 'X', 'X', 'X'}, // [X, X, X, X]
            {'X', 'O', 'O', 'X'}, // [X, X, X, X]
            {'X', 'X', 'O', 'X'}, // [X, X, X, X]
            {'X', 'O', 'X', 'X'}, // [X, O, X, X]
        };
        S.solve(b1);
        print(b1);

        char[][] b2 = {
            {'O', 'X', 'X', 'O', 'X'}, // [O, X, X, O, X]
            {'X', 'O', 'O', 'X', 'O'}, // [X, X, X, X, O]
            {'X', 'O', 'X', 'O', 'X'}, // [X, X, X, O, X]
            {'O', 'X', 'O', 'O', 'O'}, // [O, X, O, O, O]
            {'X', 'X', 'O', 'X', 'O'}, // [X, X, O, X, O]
        };
        S.solve(b2);
        print(b2);

        char[][] b3 = {
            {'O', 'O', 'O', 'O', 'X', 'X'}, // [O, O, O, O, X, X]
            {'O', 'O', 'O', 'O', 'O', 'O'}, // [O, O, O, O, O, O]
            {'O', 'X', 'O', 'X', 'O', 'O'}, // [O, X, O, X, O, O]
            {'O', 'X', 'O', 'O', 'X', 'O'}, // [O, X, O, O, X, O]
            {'O', 'X', 'O', 'X', 'O', 'O'}, // [O, X, O, X, O, O]
            {'O', 'X', 'O', 'O', 'O', 'O'}, // [O, X, O, O, O, O]
        };
        S.solve(b3);
        print(b3);
    }
}
