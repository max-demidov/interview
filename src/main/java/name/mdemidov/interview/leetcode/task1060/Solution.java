package name.mdemidov.interview.leetcode.task1060;

/**
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 *
 * <p>1060. Missing Element in Sorted Array
 *
 * <p>Given a sorted array A of unique numbers, find the K-th missing number starting from the
 * leftmost number of the array.
 *
 * <pre>
 * Example 1:
 *
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 *
 * Example 2:
 *
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 *
 * Example 3:
 *
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation:
 * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 *
 * Note:
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 * </pre>
 */
public class Solution {

  private static final Solution S = new Solution();

  public int missingElement(int[] nums, int k) {
    int j = k;
    for (int i = 1; i < nums.length; i++) {
      int diff = nums[i] - nums[i - 1] - 1;
      if (diff > 0) {
        if (diff + 1 > j) {
          return nums[i - 1] + j;
        } else {
          j -= diff;
        }
      }
    }
    return nums[nums.length - 1] + j;
  }

  public static void main(String[] args) {
    System.out.println(S.missingElement(new int[] {4, 7, 9, 10}, 1)); // 5
    System.out.println(S.missingElement(new int[] {4, 7, 9, 10}, 3)); // 8
    System.out.println(S.missingElement(new int[] {1, 2, 4}, 3)); // 6
    System.out.println(S.missingElement(new int[] {1, 3, 6, 7, 9}, 6)); // 11
    System.out.println(
        S.missingElement(
            new int[] {746421, 1033196, 1647541, 4775111, 7769817, 8030384}, 10)); // 746431
  }
}
