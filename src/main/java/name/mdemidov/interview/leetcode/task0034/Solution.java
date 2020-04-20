package name.mdemidov.interview.leetcode.task0034;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class Solution {

    public static void main(String[] args) {
        print(new int[]{}, 1); // [-1, -1]
        print(new int[]{1}, 1); // [0, 0]
        print(new int[]{1}, 0); // [-1, -1]
        print(new int[]{1}, 2); // [-1, -1]
        print(new int[]{1, 1}, 1); // [0, 1]
        print(new int[]{1, 1}, 2); // [-1, -1]
        print(new int[]{1, 2}, 2); // [1, 1]
        print(new int[]{1, 2}, 3); // [-1, -1]
        print(new int[]{1, 2, 3}, 2); // [1, 1]
        print(new int[]{1, 2, 2, 3}, 2); // [1, 2]
        print(new int[]{5, 7, 7, 8, 8, 10}, 8); // [3, 4]
        print(new int[]{5, 7, 7, 8, 8, 10}, 6); // [-1, -1]
    }

    private static int searchMinIndex(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (nums[left] == target) {
            return left;
        }
        int mid = (left + right) / 2;
        if (target <= nums[mid]) {
            return searchMinIndex(nums, target, left + 1, mid);
        } else {
            return searchMinIndex(nums, target, mid + 1, right);
        }
    }

    private static int searchMaxIndex(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (nums[right] == target) {
            return right;
        }
        int mid = (left + right) / 2;
        if (target >= nums[mid]) {
            return searchMaxIndex(nums, target, mid, right - 1);
        } else {
            return searchMaxIndex(nums, target, left, mid - 1);
        }
    }

    private static void print(int[] nums, int target) {
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int minIndex = searchMinIndex(nums, target, 0, nums.length - 1);
        int maxIndex = searchMaxIndex(nums, target, Math.max(0, minIndex), nums.length - 1);
        return new int[]{minIndex, maxIndex};
    }
}
