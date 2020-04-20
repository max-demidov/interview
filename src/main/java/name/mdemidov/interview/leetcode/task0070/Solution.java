package name.mdemidov.interview.leetcode.task0070;

public class Solution {

    public static void main(String[] args) {
        int input = 45;
        int output = new Solution().climbStairs(input);
        System.out.println(output);
    }

    public int climbStairs(int n) {
        int[] f = new int[]{1, 1, 2};
        for (int i = 3; i <= n; i++) {
            f[i % 3] = f[(i - 1) % 3] + f[(i - 2) % 3];
        }
        return f[n % 3];
    }
}
