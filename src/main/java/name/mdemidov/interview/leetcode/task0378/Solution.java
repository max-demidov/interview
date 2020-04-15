package name.mdemidov.interview.leetcode.task0378;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int kthSmallest(int[][] matrix, int k) {
        int size = Math.min(k, matrix.length);
        int[] array = new int[size * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i * size + j] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(S.kthSmallest(m1, 8)); // 13
        int[][] m2 = new int[][]{
            {1, 3, 5},
            {6, 7, 12},
            {11, 14, 14}
        };
        System.out.println(S.kthSmallest(m2, 3)); // 5
    }
}
