package name.mdemidov.interview.leetcode.task0347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {

    private static final Solution S = new Solution();

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(S.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)); // [1, 2]
        System.out.println(S.topKFrequent(new int[]{1}, 1)); // [1]
    }
}
