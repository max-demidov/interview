package name.mdemidov.interview.leetcode.task169;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            counts.put(num, count);
        }
        return 0;
    }

    // The best solution:
    //    public int majorityElement(int[] nums) {
    //        int num = nums[0], freq = 1;
    //        for(int i = 1; i < nums.length; i++) {
    //            if(nums[i] == num) {
    //                freq++;
    //            } else {
    //                freq--;
    //                if(freq == 0) {
    //                    num = nums[i];
    //                    freq = 1;
    //                }
    //            }
    //        }
    //
    //        return num;
    //    }

}
