package name.mdemidov.interview.leetcode.task0268;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 */
public class Solution {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean contains = false;
            for (int num : nums) {
                if (i == num) {
                    contains |= true;
                    break;
                }
            }
            if (!contains) {
                return i;
            }
        }
        return nums.length;
    }

}
