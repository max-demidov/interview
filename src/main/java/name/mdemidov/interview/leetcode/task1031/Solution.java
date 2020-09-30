package name.mdemidov.interview.leetcode.task1031;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 *
 * <p>1031. Maximum Sum of Two Non-Overlapping Subarrays
 *
 * <p>Given an array A of non-negative integers, return the maximum sum of elements in two
 * non-overlapping (contiguous) subarrays, which have lengths L and M. (For clarification, the
 * L-length subarray could occur before or after the M-length subarray.)
 *
 * <p>Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1]
 * + ... + A[j+M-1]) and either:
 *
 * <p>0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
 *
 * <p>0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 *
 * <p>Example 1:
 *
 * <p>Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 *
 * <p>Output: 20
 *
 * <p>Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
 *
 * <p>Example 2:
 *
 * <p>Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 *
 * <p>Output: 29
 *
 * <p>Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
 *
 * <p>Example 3:
 *
 * <p>Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 *
 * <p>Output: 31
 *
 * <p>Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
 *
 * <p>Note:
 *
 * <p>L >= 1
 *
 * <p>M >= 1
 *
 * <p>L + M <= A.length <= 1000
 *
 * <p>0 <= A[i] <= 1000
 */
public class Solution {

  private static final Solution S = new Solution();

  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    int[] sumL = prefixSum(A, L);
    int[] sumM = prefixSum(A, M);
    int max = 0;
    for (int i = 0; i <= A.length - L; i++) {
      max = Math.max(max, sumL[i] + bestM(sumM, M, i, i + L));
    }
    return max;
  }

  private static int bestM(int[] sumM, int M, int start, int end) {
    int max = 0;
    for (int i = 0; i < sumM.length; i++) {
      if (i >= start - M && i < end) {
        continue;
      }
      max = Math.max(max, sumM[i]);
    }
    return max;
  }

  private static int[] prefixSum(int[] A, int l) {
    int[] res = new int[A.length - l + 1];
    for (int i = 0; i <= A.length - l; i++) {
      for (int j = 0; j < l; j++) {
        res[i] += A[i + j];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(S.maxSumTwoNoOverlap(new int[] {0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2)); // 20
    System.out.println(S.maxSumTwoNoOverlap(new int[] {3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2)); // 29
    System.out.println(S.maxSumTwoNoOverlap(new int[] {2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3)); // 31
    System.out.println(S.maxSumTwoNoOverlap(new int[] {1, 0, 3}, 1, 2)); // 4
    System.out.println(
        S.maxSumTwoNoOverlap(new int[] {8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12}, 5, 4)); // 108
  }
}
