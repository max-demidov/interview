package name.mdemidov.interview.leetcode.task448;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> output = new Solution().findDisappearedNumbers(input);
        System.out.println(output);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
