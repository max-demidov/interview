package name.mdemidov.interview.leetcode.task048;

import java.util.Arrays;

/**
 * 48. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix
 * directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 *
 * Example 2:
 *
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix0 = new int[][]{};
        int[][] matrix1 = {
            {1} // [1]
        };
        int[][] matrix2 = {
            {1, 2}, // [3, 1]
            {3, 4}  // [4, 2]
        };
        int[][] matrix3 = {
            {1, 2, 3}, // [7, 4, 1]
            {4, 5, 6}, // [8, 5, 2]
            {7, 8, 9}  // [9, 6, 3]
        };
        int[][] matrix4 = {
            {5, 1, 9, 11},   // [15, 13, 2, 5]
            {2, 4, 8, 10},   // [14, 3, 4, 1]
            {13, 3, 6, 7},   // [12, 6, 8, 9]
            {15, 14, 12, 16} // [16, 7, 10, 11]
        };
        int[][] matrix5 = {
            {1, 2, 3, 4, 5},      // [21, 16, 11, 6, 1]
            {6, 7, 8, 9, 10},     // [22, 17, 12, 7, 2]
            {11, 12, 13, 14, 15}, // [23, 18, 13, 8, 3]
            {16, 17, 18, 19, 20}, // [24, 19, 14, 9, 4]
            {21, 22, 23, 24, 25}  // [25, 20, 15, 10, 5]
        };
        int[][] matrix6 = {
            {1, 2, 3, 4, 5, 6},       // [31, 25, 19, 13, 7, 1]
            {7, 8, 9, 10, 11, 12},    // [32, 26, 20, 14, 8, 2]
            {13, 14, 15, 16, 17, 18}, // [33, 27, 21, 15, 9, 3]
            {19, 20, 21, 22, 23, 24}, // [34, 28, 22, 16, 10, 4]
            {25, 26, 27, 28, 29, 30}, // [35, 29, 23, 17, 11, 5]
            {31, 32, 33, 34, 35, 36}  // [36, 30, 24, 18, 12, 6]
        };
        new Solution().rotate(matrix0);
        new Solution().rotate(matrix1);
        new Solution().rotate(matrix2);
        new Solution().rotate(matrix3);
        new Solution().rotate(matrix4);
        new Solution().rotate(matrix5);
        new Solution().rotate(matrix6);
        print(matrix0);
        print(matrix1);
        print(matrix2);
        print(matrix3);
        print(matrix4);
        print(matrix5);
        print(matrix6);
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        int size = matrix.length;
        if (size < 2) {
            return;
        }
        for (int ring = 0; ring < size / 2; ring++) {
            for (int i = ring; i < size - ring - 1; i++) {
                int tmp = matrix[ring][i];
                matrix[ring][i] = matrix[size - i - 1][ring];
                matrix[size - i - 1][ring] = matrix[size - ring - 1][size - i - 1];
                matrix[size - ring - 1][size - i - 1] = matrix[i][size - ring - 1];
                matrix[i][size - ring - 1] = tmp;
            }
        }
    }

}
