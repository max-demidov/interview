package name.mdemidov.interview.leetcode.task0324;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * <p>
 * 324. Wiggle Sort II
 * <p>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 5, 1, 1, 6, 4] Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 2, 2, 3, 1] Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * <p>
 * Note:
 * <p>
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * <p>
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Solution {

  private static final Solution S = new Solution();

  public void wiggleSort(int[] nums) {
    int[] copy = new int[nums.length];
    System.arraycopy(nums, 0, copy, 0, nums.length);
    Arrays.sort(copy);
    int rem = nums.length % 2;
    int j = 0;
    for (int i = nums.length + rem - 2; i >= 0; i -= 2) {
      nums[i] = copy[j++];
    }
    for (int i = nums.length - rem - 1; i >= rem; i -= 2) {
      nums[i] = copy[j++];
    }
  }

  public static void main(String[] args) {
    int[] a1 = {1, 5, 1, 1, 6, 4};
    S.wiggleSort(a1);
    System.out.println(Arrays.toString(a1)); // [1, 6, 1, 5, 1, 4]

    int[] a2 = {1, 3, 2, 2, 3, 1};
    S.wiggleSort(a2);
    System.out.println(Arrays.toString(a2)); // [2, 3, 1, 3, 1, 2]

    int[] a3 = {1, 1, 2, 1, 2, 2, 1};
    S.wiggleSort(a3);
    System.out.println(Arrays.toString(a3)); // [1, 2, 1, 2, 1, 2, 1]

    int[] a4 = {1, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 2};
    S.wiggleSort(a4);
    System.out.println(Arrays.toString(a4)); // [1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1]

    int[] a5 = {4, 5, 5, 6};
    S.wiggleSort(a5);
    System.out.println(Arrays.toString(a5)); // [5, 6, 4, 5]
  }
}
