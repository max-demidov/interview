package name.mdemidov.interview.leetcode.task073;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 * Example 2:
 *
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Solution {

    public static void main(String[] args) {
        int[][] m1 = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int[][] m2 = new int[][]{
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        new Solution().setZeroes(m1);
        new Solution().setZeroes(m2);
        print(m1);
        print(m2);
    }

    private static void print(int[][] array) {
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length < 1) {
            return;
        }
        boolean[] xZeros = new boolean[matrix.length];
        boolean[] yZeros = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xZeros[i] = true;
                    yZeros[j] = true;
                }
            }
        }
        for (int i = 0; i < xZeros.length; i++) {
            if (xZeros[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < yZeros.length; j++) {
            if (yZeros[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
