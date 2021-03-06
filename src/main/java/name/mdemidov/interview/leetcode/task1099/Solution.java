package name.mdemidov.interview.leetcode.task1099;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-less-than-k/
 *
 * 1099. Two Sum Less Than K
 *
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j
 * with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 *
 * Example 1:
 *
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 *
 * Example 2:
 *
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 1000
 * 1 <= K <= 2000
 */
public class Solution {

    private static final Solution S = new Solution();

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= K) {
                break;
            }
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (sum >= K) {
                    break;
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(S.twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60)); // 58
        System.out.println(S.twoSumLessThanK(new int[]{10, 20, 30}, 15)); // -1
    }
}
