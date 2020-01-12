package name.mdemidov.interview.leetcode.task0163;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/missing-ranges/
 *
 * 163. Missing Ranges
 *
 * Given a sorted integer array nums, where the range of elements are in the inclusive range
 * [lower, upper], return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class Solution {

    private static final Solution S = new Solution();

    private static String range(int a, int b) {
        return a == b ? String.valueOf(a) : String.format("%d->%d", a, b);
    }

    private static void print(int[] nums, int lower, int upper) {
        System.out.println(S.findMissingRanges(nums, lower, upper));
    }

    public static void main(String[] args) {
        print(new int[]{0, 1, 3, 50, 75}, 0, 99); // [2, 4->49, 51->74, 76->99]
        print(new int[]{-1}, -2, -1); // [-2]
        print(new int[]{-1}, -1, 0); // [0]
        print(new int[]{2147483647}, 0, 2147483647); // [0->2147483646]
        print(new int[]{-2147483648}, -2147483648, 2147483647); // [-2147483647->2147483647]
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length < 1) {
            res.add(range(lower, upper));
            return res;
        }
        for (int num : nums) {
            if (num < lower) {
                continue;
            }
            if (num > upper || num == Integer.MAX_VALUE) {
                if (upper == Integer.MAX_VALUE) {
                    upper--;
                }
                break;
            }
            if (num > lower) {
                res.add(range(lower, num - 1));
            }
            lower = num + 1;
        }
        if (upper >= lower) {
            res.add(range(lower, upper));
        }
        return res;
    }

}
