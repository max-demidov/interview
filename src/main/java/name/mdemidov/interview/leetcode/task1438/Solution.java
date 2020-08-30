package name.mdemidov.interview.leetcode.task1438;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * <p>
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * <p>
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty
 * subarray such that the absolute difference between any two elements of this subarray is less than
 * or equal to limit.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * </pre>
 * <p>
 * Example 3:
 * <pre>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * <li>1 <= nums.length <= 10^5
 * <li>1 <= nums[i] <= 10^9
 * <li>0 <= limit <= 10^9
 */
public class Solution {

  private static final Solution S = new Solution();

  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> maxDeque = new LinkedList<>();
    Deque<Integer> minDeque = new LinkedList<>();
    int l = 0;
    int r = 0;
    while (r < nums.length) {
      while (maxDeque.size() > 0 && nums[r] > maxDeque.peekLast()) {
        maxDeque.pollLast();
      }
      while (minDeque.size() > 0 && nums[r] < minDeque.peekLast()) {
        minDeque.pollLast();
      }
      maxDeque.offerLast(nums[r]);
      minDeque.offerLast(nums[r]);
      if (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
        if (nums[l] == maxDeque.peekFirst()) {
          maxDeque.pollFirst();
        }
        if (nums[l] == minDeque.peekFirst()) {
          minDeque.pollFirst();
        }
        l++;
      }
      r++;
    }
    return r - l;
  }

  public static void main(String[] args) {
    System.out.println(S.longestSubarray(new int[]{8, 2, 4, 7}, 4)); // 2
    System.out.println(S.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5)); // 4
    System.out.println(S.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0)); // 3
  }
}
