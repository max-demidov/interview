package name.mdemidov.interview.leetcode.task0240;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int yMin = -1;
        int yMax = matrix.length - 1;
        int xMin = -1;
        int xMax = matrix[0].length - 1;
        for (int y = 0; y < matrix.length; y++) {
            if (matrix[y][0] <= target && target <= matrix[y][xMax]) {
                if (yMin < 0) {
                    yMin = y;
                }
                yMax = y;
            }
        }
        if (yMin < 0) {
            return false;
        }

        for (int x = 0; x < matrix[0].length; x++) {
            if (matrix[yMin][x] <= target && target <= matrix[yMax][x]) {
                if (xMin < 0) {
                    xMin = x;
                }
                xMax = x;
            }
        }
        if (xMin < 0) {
            return false;
        }

        for (int y = yMin; y <= yMax; y++) {
            for (int x = xMin; x <= xMax; x++) {
                if (matrix[y][x] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{
            { 1,  4,  7, 11, 15},
            { 2,  5,  8, 12, 19},
            { 3,  6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(S.searchMatrix(m1, 5)); // true
        System.out.println(S.searchMatrix(m1, 20)); // false
        int[][] m2 = new int[][]{
            {-5}
        };
        System.out.println(S.searchMatrix(m2, -5)); // true
        System.out.println(S.searchMatrix(m2, -2)); // false
        int[][] m3 = new int[][]{
            { 1,  3,  5,  7,  9},
            { 2,  4,  6,  8, 10},
            {11, 13, 15, 17, 19},
            {12, 14, 16, 18, 20},
            {21, 22, 23, 24, 25}
        };
        System.out.println(S.searchMatrix(m3, 13)); // true
        int[][] m4 = new int[][]{
            {1, 4},
            {2, 5}
        };
        System.out.println(S.searchMatrix(m4, 4)); // true
    }
}
