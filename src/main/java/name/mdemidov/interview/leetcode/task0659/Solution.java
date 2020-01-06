package name.mdemidov.interview.leetcode.task0659;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 *
 * 659. Split Array into Consecutive Subsequences
 *
 * Given an array nums sorted in ascending order, return true if and only if you can split it into
 * 1 or more subsequences such that each subsequence consists of consecutive integers and has
 * length at least 3.
 *
 * Example 1:
 *
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 *
 * Example 2:
 *
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 * Example 3:
 *
 * Input: [1,2,3,4,4,5]
 * Output: False
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10000
 */
public class Solution {

    private static final Solution S = new Solution();

    private static void print(int... nums) {
        System.out.println(S.isPossible(nums));
    }

    public static void main(String[] args) {
        print(1, 2, 3, 4); // true // [1, 1, 1, 1]
        print(1, 2, 3, 11, 12, 13); // true // [1, 1, 1, 1, 1, 1]
        print(1, 2, 3, 3, 4, 5); // true // [1, 1, 2, 1, 1]
        print(1, 2, 2, 3, 3, 4); // true // [1, 2, 2, 1]
        print(1, 1, 2, 2, 3, 3); // true // [2, 2, 2]
        print(1, 2, 3, 3, 4, 4, 5, 5); // true // [1, 1, 2, 2, 2]
        print(1, 2, 2, 3, 3, 3, 4, 4, 5); // true // [1, 2, 3, 2, 1]
        print(1, 1, 2, 2, 3, 3, 4, 6, 7, 7, 8, 8, 9, 9); // true // [2, 2, 2, 1, 1, 2, 2, 2]

        print(1, 2, 3, 4, 4, 5); // false // [1, 1, 1, 2, 1]
        print(2, 3, 3, 4, 5, 5, 6, 6); // false // [1, 2, 1, 2, 2]
        print(1, 1, 2, 2, 4, 4); // false // [2, 2, 2]
    }

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int n : nums) {
            int c = count.getOrDefault(n, 0);
            count.put(n, c + 1);
        }
        return isPossible(count);
    }

    private static boolean isPossible(Map<Integer, Integer> count) {
        if (count.isEmpty()) {
            return true;
        }
        int num = 0;
        Map.Entry<Integer, Integer> last = null;
        List<Integer> decrease = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (num > 0
                && (entry.getKey() - last.getKey() > 1 || entry.getValue() < last.getValue())) {
                break;
            }
            decrease.add(entry.getKey());
            last = entry;
            num++;
        }
        if (num < 3) {
            return false;
        }
        for (int k : decrease) {
            if (count.get(k) < 2) {
                count.remove(k);
            } else {
                count.put(k, count.get(k) - 1);
            }
        }
        return isPossible(count);
    }
}
