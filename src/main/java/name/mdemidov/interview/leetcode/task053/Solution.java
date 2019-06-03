package name.mdemidov.interview.leetcode.task053;

public class Solution {

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int output = new Solution().maxSubArray(input);
        System.out.println(output);
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int localSum = 0;
        for (int num : nums) {
            localSum += num;
            if (localSum > maxSum) {
                maxSum = localSum;
            }
            if (localSum < 0) {
                localSum = 0;
            }
        }
        return maxSum;
    }
}
