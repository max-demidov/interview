package name.mdemidov.interview.leetcode.task1007;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * 1007. Minimum Domino Rotations For Equal Row
 *
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same,
 * or all the values in B are the same.
 *
 * If it cannot be done, return -1.
 *
 * Example 1:
 *
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2,
 * as indicated by the second figure.
 *
 * Example 2:
 *
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int minDominoRotations(int[] A, int[] B) {
        int a = A[0];
        int b = B[0];
        int countA = 1;
        int countB = 1;
        int topA = 1;
        int bottomA = 0;
        int topB = 0;
        int bottomB = 1;
        for (int i = 1; i < A.length; i++) {
            if (countA > 0) {
                if (a == A[i] || a == B[i]) {
                    countA++;
                    if (a == A[i]) {
                        topA++;
                    }
                    if (a == B[i]) {
                        bottomA++;
                    }
                } else {
                    countA = -1;
                }
            }
            if (countB > 0) {
                if (b == A[i] || b == B[i]) {
                    countB++;
                    if (b == A[i]) {
                        topB++;
                    }
                    if (b == B[i]) {
                        bottomB++;
                    }
                } else {
                    countB = -1;
                }
            }
            if (countA < i && countB < i) {
                return -1;
            }
        }

        int rotA = countA > 0 ? countA - Integer.max(topA, bottomA) : Integer.MAX_VALUE;
        int rotB = countB > 0 ? countB - Integer.max(topB, bottomB) : Integer.MAX_VALUE;
        return Integer.min(rotA, rotB);
    }

    public static void main(String[] args) {
        int[] a1 = {2, 1, 2, 4, 2, 2};
        int[] b1 = {5, 2, 6, 2, 3, 2};
        System.out.println(S.minDominoRotations(a1, b1));

        int[] a2 = {3, 5, 1, 2, 3};
        int[] b2 = {3, 6, 3, 3, 4};
        System.out.println(S.minDominoRotations(a2, b2));
    }
}
