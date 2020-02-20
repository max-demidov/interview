package name.mdemidov.interview.leetcode.task0835;

/**
 * https://leetcode.com/problems/image-overlap/
 *
 * 835. Image Overlap
 *
 * Two images A and B are given, represented as binary, square matrices of the same size.
 * (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up,
 * or down any number of units), and place it on top of the other image.
 * After, the overlap of this translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 *
 * Input:
 * A =
 * [[1,1,0],
 * [0,1,0],
 * [0,1,0]]
 * B =
 * [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 *
 * Notes:
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class Solution {

    private static final Solution S = new Solution();

    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for (int j = 1 - A.length; j < A.length; j++) {
            for (int i = 1 - A.length; i < A.length; i++) {
                max = Math.max(max, overlap(A, B, j, i));
            }
        }
        return max;
    }

    private static int overlap(int[][] A, int[][] B, int y, int x) {
        int yMax = A.length - Math.abs(y);
        int xMax = A.length - Math.abs(x);
        int o = 0;
        for (int j = 0; j < yMax; j++) {
            for (int i = 0; i < xMax; i++) {
                if (A[j + (y > 0 ? y : 0)][i + (x > 0 ? x : 0)] == 1
                    && B[j - (y < 0 ? y : 0)][i - (x < 0 ? x : 0)] == 1) {
                    o++;
                }
            }
        }
        return o;
    }

    public static void main(String[] args) {
        int[][] A1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };
        int[][] B1 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };
        System.out.println(S.largestOverlap(A1, B1));
        int[][] A2 = {
            {1}
        };
        int[][] B2 = {
            {1}
        };
        System.out.println(S.largestOverlap(A2, B2));
    }
}
