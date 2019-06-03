package name.mdemidov.interview.leetcode.task035;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {};
        int target = 2;
        System.out.println(new Solution().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i] || nums[i]> target) {
                return i;
            }
        }
        return nums.length;
    }

}
