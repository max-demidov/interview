package name.mdemidov.interview.leetcode.task046;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2]
 * Output:
 * [
 * [1,2],
 * [2,1]
 * ]
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1}));
        System.out.println(new Solution().permute(new int[]{1, 2}));
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{1, 2, 3, 4}));
    }

    private static List<List<Integer>> permute(List<List<Integer>> in, int[] nums, int n) {
        if (n >= nums.length) {
            return in;
        }
        if (in.isEmpty()) {
            in.add(Collections.singletonList(nums[n]));
            return permute(in, nums, n + 1);
        }
        List<List<Integer>> out = new ArrayList<>();
        for (List<Integer> list : in) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, nums[n]);
                out.add(newList);
            }
        }
        return permute(out, nums, n + 1);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1) {
            return Collections.emptyList();
        }
        return permute(new ArrayList<>(), nums, 0);
    }
}
