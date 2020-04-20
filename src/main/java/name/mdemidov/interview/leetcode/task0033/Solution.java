package name.mdemidov.interview.leetcode.task0033;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search.
 * If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(new Solution().search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0)); // 0
        System.out.println(new Solution().search(new int[]{0, 1, 2, 4, 5, 6, 7}, 7)); // 6
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1}, 5)); // 1
        System.out.println(new Solution().search(new int[]{}, 5)); // -1
        System.out.println(new Solution().search(new int[]{1}, 0)); // -1
    }

    private static int search(int[] nums, int target, int left, int right) {
        if (left >= right) {
            return target == nums[left] ? left : -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (target <= nums[mid]) {
            return search(nums, target, left, mid);
        } else {
            return search(nums, target, mid + 1, right);
        }
    }

    private static int pivotIndex(int[] nums) {
        return pivotIndex(nums, 0, nums.length - 1);
    }

    private static int pivotIndex(int[] nums, int left, int right) {
        if (nums[left] <= nums[right]) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[left] > nums[mid]) {
            return pivotIndex(nums, left, mid);
        } else {
            return pivotIndex(nums, mid + 1, right);
        }
    }

    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        int pivotIndex = pivotIndex(nums);
        if (pivotIndex < 1) {
            return search(nums, target, 0, nums.length - 1);
        }
        if (target >= nums[0]) {
            return search(nums, target, 0, pivotIndex - 1);
        } else {
            return search(nums, target, pivotIndex, nums.length - 1);
        }
    }

}
