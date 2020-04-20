package name.mdemidov.interview.leetcode.task0121;

public class Solution {

    public static void main(String[] args) {
        int[] input1 = {7, 1, 5, 3, 6, 4};
        int output1 = new Solution().maxProfit(input1);
        System.out.println(output1);

        int[] input2 = {7, 6, 4, 3, 1};
        int output2 = new Solution().maxProfit(input2);
        System.out.println(output2);
    }

    public int maxProfit(int[] prices) {
        int maxSum = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxSum) {
                maxSum = price - minPrice;
            }
        }
        return maxSum;
    }
}
