package name.mdemidov.interview.leetcode.task0078;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution {

    // []:      []
    // [1]:     [],[1]
    // [1,2]:   [],[1],[2],[1,2]
    // [1,2,3]: [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3};
        System.out.println(new Solution().subsets(input1));
    }

    private static List<List<Integer>> subsets(int[] nums, int index) {
        if (index < 0) {
            List<Integer> single = Collections.emptyList();
            List<List<Integer>> res = new ArrayList<>();
            res.add(single);
            return res;
        }
        return append(subsets(nums, index - 1), nums[index]);
    }

    private static List<List<Integer>> append(List<List<Integer>> subset, int n) {
        List<List<Integer>> extension = new ArrayList<>(subset.size());
        for (List<Integer> set : subset) {
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(n);
            extension.add(newSet);
        }
        subset.addAll(extension);
        return subset;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length - 1);
    }
}
