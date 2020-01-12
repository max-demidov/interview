package name.mdemidov.interview.leetcode.task0221;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 * 221. Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class Solution {

    private static final Solution S = new Solution();

    public static void main(String[] args) {
        char[][] m1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(S.maximalSquare(m1));
        char[][] m2 = {
            {'0', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '1'},
            {'1', '0', '1', '0', '1'},
            {'0', '1', '1', '1', '0'}
        };
        System.out.println(S.maximalSquare(m2));
        char[][] m3 = {
            {'0'}
        };
        System.out.println(S.maximalSquare(m3));
        char[][] m4 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(S.maximalSquare(m4));
        char[][] m5 = {
            {'1', '1', '0', '1'},
            {'1', '1', '0', '1'},
            {'1', '1', '1', '1'}
        };
        System.out.println(S.maximalSquare(m5));
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int y = 0; y < matrix.length - max; y++) {
            for (int x = 0; x < matrix[0].length - max; x++) {
                max = Integer.max(max, max(matrix, y, x));
            }
        }
        return (int) Math.pow(max, 2);
    }

    private static int max(char[][] matrix, int y, int x) {
        if (matrix[y][x] != '1') {
            return 0;
        }
        int max = Integer.min(matrix.length - y, matrix[0].length - x);
        for (int j = 0; j < max; j++) {
            for (int i = 0; i < max; i++) {
                if (matrix[y + j][x + i] != '1') {
                    max = Integer.min(max, Integer.max(j, i));
                }
            }
        }
        return max;
    }

}
