package name.mdemidov.interview.leetcode.task0350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {2, 1};
        int[] intersect = new Solution().intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    private static Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        return map;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = count(nums1);
        Map<Integer, Integer> map2 = count(nums2);
        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            int min = Math.min(e.getValue(), map2.getOrDefault(e.getKey(), 0));
            for (int i = 0; i < min; i++) {
                list.add(e.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
