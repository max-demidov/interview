package name.mdemidov.interview.leetcode.task0801;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * 801. Minimum Swaps To Make Sequences Increasing
 *
 * We have two integer sequences A and B of the same non-zero length.
 *
 * We are allowed to swap elements A[i] and B[i].
 * Note that both elements are in the same index position in their respective sequences.
 *
 * At the end of some number of swaps, A and B are both strictly increasing.
 * (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 *
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.
 * It is guaranteed that the given input always makes it possible.
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 *
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 *
 * Note:
 * A, B are arrays with the same length, and that length will be in the range [1, 1000].
 * A[i], B[i] are integer values in the range [0, 2000].
 */
public class Solution {

    private static final Solution S = new Solution();

    public int minSwap(int[] A, int[] B) {
        int[] swap = new int[A.length];
        int[] notSwap = new int[A.length];
        swap[0] = 1;
        for (int i = 1; i < A.length; ++i) {
            notSwap[i] = Integer.MAX_VALUE;
            swap[i] = Integer.MAX_VALUE;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                notSwap[i] = notSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                notSwap[i] = Math.min(notSwap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
            }
        }
        return Math.min(swap[A.length - 1], notSwap[A.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(
            S.minSwap(
                new int[]{1, 3, 5, 4},
                new int[]{1, 2, 3, 7}
            )
        ); // 1
        System.out.println(
            S.minSwap(
                new int[]{0, 3, 5, 8, 9},
                new int[]{2, 1, 4, 6, 9}
            )
        ); // 1
        System.out.println(
            S.minSwap(
                new int[]{0, 4, 4, 5, 9},
                new int[]{0, 1, 6, 8, 10}
            )
        ); // 1
        System.out.println(
            S.minSwap(
                new int[]{0, 7, 8, 10, 10, 11, 12, 13, 19, 18},
                new int[]{4, 4, 5, 7, 11, 14, 15, 16, 17, 20}
            )
        ); // 4
    }
}
