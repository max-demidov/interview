package name.mdemidov.interview.leetcode.task283;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 0, 6};
        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i > n) {
                nums[n] = nums[i];
                nums[i] = 0;
            }
            n++;
        }
    }

}
