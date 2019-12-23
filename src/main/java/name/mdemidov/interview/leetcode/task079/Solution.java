package name.mdemidov.interview.leetcode.task079;

import java.util.Arrays;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class Solution {

    public static void main(String[] args) {
        final char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution().exist(board, "ABCCED"));
        System.out.println(new Solution().exist(board, "SEE"));
        System.out.println(new Solution().exist(board, "ABCB"));

        final char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'E', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution().exist(board1, "ABCESEEEFS"));
    }

    private static void print(char[][] array) {
        for (char[] i : array) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    private static char[][] copy(char[][] array) {
        char[][] copy = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return copy;
    }

    private static boolean exist(char[][] board, String word, int charIndex, int x, int y) {
        if (charIndex >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || y >= board.length || x >= board[0].length
            || board[y][x] != word.charAt(charIndex)) {
            return false;
        }
        char[][] newBoard = copy(board);
        newBoard[y][x] = ' ';
        return exist(newBoard, word, charIndex + 1, x - 1, y)
               || exist(newBoard, word, charIndex + 1, x + 1, y)
               || exist(newBoard, word, charIndex + 1, x, y - 1)
               || exist(newBoard, word, charIndex + 1, x, y + 1);
    }

    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (exist(copy(board), word, 0, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

}
