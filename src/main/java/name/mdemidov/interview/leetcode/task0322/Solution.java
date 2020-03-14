package name.mdemidov.interview.leetcode.task0322;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int rem, int[] count) {
        if (rem == 0) {
            return 0;
        }
        if (rem < 0) {
            return -1;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int tmp = coinChange(coins, rem - c, count);
            if (0 <= tmp && tmp < min) {
                min = tmp + 1;
            }
        }
        count[rem - 1] = min < Integer.MAX_VALUE ? min : -1;
        return count[rem - 1];
    }

    public static void main(String[] args) {
        System.out.println(S.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(S.coinChange(new int[]{2}, 3)); // -1
        System.out.println(S.coinChange(new int[]{1}, 0)); // 0
        System.out.println(S.coinChange(new int[]{1, 2, 5}, 100)); // 20
        System.out.println(S.coinChange(new int[]{186, 419, 83, 408}, 6249)); // 20
    }
}
