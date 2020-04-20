package name.mdemidov.interview.leetcode.task0054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix0 = new int[][]{};
        int[][] matrix11 = new int[][]{{11}};
        int[][] matrix22 = new int[][]{
            {11, 12},
            {21, 22}
        };
        int[][] matrix33 = new int[][]{
            {11, 12, 13},
            {21, 22, 23},
            {31, 32, 33}
        };
        int[][] matrix34 = new int[][]{
            {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34}
        };
        int[][] matrix43 = new int[][]{
            {11, 12, 13},
            {21, 22, 23},
            {31, 32, 33},
            {41, 42, 43}
        };
        int[][] matrix44 = {
            {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34},
            {41, 42, 43, 44}
        };
        int[][] matrix55 = {
            {11, 12, 13, 14, 15},
            {21, 22, 23, 24, 25},
            {31, 32, 33, 34, 35},
            {41, 42, 43, 44, 45},
            {51, 52, 53, 54, 55}
        };
        System.out.println(new Solution().spiralOrder(matrix0));
        System.out.println(new Solution().spiralOrder(matrix11));
        System.out.println(new Solution().spiralOrder(matrix22));
        System.out.println(new Solution().spiralOrder(matrix33));
        System.out.println(new Solution().spiralOrder(matrix34));
        System.out.println(new Solution().spiralOrder(matrix43));
        System.out.println(new Solution().spiralOrder(matrix44));
        System.out.println(new Solution().spiralOrder(matrix55));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            if (top > --bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return list;
    }

}
