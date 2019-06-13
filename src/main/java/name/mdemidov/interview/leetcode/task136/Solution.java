package name.mdemidov.interview.leetcode.task136;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */
public class Solution {

    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            list.add(i);
        }
        return list.stream().filter(i -> (list.indexOf(i) == list.lastIndexOf(i))).findFirst().orElse(0);
    }

}
