package name.mdemidov.interview.leetcode.task0091;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class Solution {

    private static final Solution S = new Solution();

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int size = s.length();
        int[] dp = new int[size + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= size; i++) {
            int a = s.charAt(i - 1) - '0';
            int b = s.charAt(i - 2) - '0';
            if (a > 0) {
                dp[i] += dp[i - 1];
            }
            if (b == 1 || b == 2 && a < 7) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        System.out.println(S.numDecodings("12")); // 2
        System.out.println(S.numDecodings("226")); // 3
    }
}
