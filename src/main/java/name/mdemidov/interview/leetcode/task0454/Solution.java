package name.mdemidov.interview.leetcode.task0454;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/
 *
 * 454. 4Sum II
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are
 * such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All
 * integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most
 * 2^31 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Solution {

    private static final Solution S = new Solution();

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.merge(a + b, 1, Integer::sum);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int tmp = map.getOrDefault(-c - d, 0);
                if (tmp != 0) {
                    count += tmp;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(S.fourSumCount(
            new int[]{1, 2},
            new int[]{-2, -1},
            new int[]{-1, 2},
            new int[]{0, 2}));
    }
}
