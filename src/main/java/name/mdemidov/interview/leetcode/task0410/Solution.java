package name.mdemidov.interview.leetcode.task0410;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 *
 * 410. Split Array Largest Sum
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array
 * into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among
 * these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 *
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }
        if (m == 1) {
            return (int) r;
        }
        if (m == nums.length) {
            return (int) l;
        }
        while (l < r) {
            long mid = (l + r) / 2;
            if (valid(nums, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private static boolean valid(int[] nums, int m, long max) {
        int sum = 0;
        int groups = 1;
        for (int n : nums) {
            sum += n;
            if (sum > max) {
                sum = n;
                groups++;
                if (groups > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(S.splitArray(new int[]{7, 2, 5, 10, 8}, 2)); // 18
        System.out.println(S.splitArray(new int[]{7, 2, 5, 10, 8}, 3)); // 14
    }
}
