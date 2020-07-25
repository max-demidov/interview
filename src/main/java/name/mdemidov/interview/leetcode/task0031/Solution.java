package name.mdemidov.interview.leetcode.task0031;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * <p>
 * 31. Next Permutation
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in
 * the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * <p>
 * 3,2,1 → 1,2,3
 * <p>
 * 1,1,5 → 1,5,1
 */
public class Solution {

  private static final Solution S = new Solution();

  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i < 0) {
      Arrays.sort(nums);
      return;
    }

    int min = Integer.MAX_VALUE;
    int minIndex = i + 1;
    for (int j = i + 1; j < nums.length; j++) {
      if (nums[i] < nums[j] && nums[j] < min) {
        minIndex = j;
        min = nums[j];
        if (nums[j] - nums[i] < 2) {
          break;
        }
      }
    }

    swap(nums, i, minIndex);
    Arrays.sort(nums, i + 1, nums.length);
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    print(new int[]{1, 2, 3}); // 1,3,2
    print(new int[]{3, 2, 1}); // 1,2,3
    print(new int[]{1, 1, 5}); // 1,5,1
    print(new int[]{1, 2, 2}); // 2, 1, 2
    print(new int[]{2, 2, 1}); // 1,2,2
    print(new int[]{2, 1, 3}); // 2,3,1
    print(new int[]{1, 2, 1}); // 2,1,1
    print(new int[]{1, 3, 2}); // 2,1,3
    print(new int[]{1, 2, 2, 1}); // 2,1,1,2
    print(new int[]{1}); // 1
    print(new int[]{1, 5, 1}); // 5,1,1
  }

  public static void print(int[] nums) {
    S.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }
}
