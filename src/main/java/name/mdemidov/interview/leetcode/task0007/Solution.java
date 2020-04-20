package name.mdemidov.interview.leetcode.task0007;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483648));
    }

    public int reverse(int x) {
        int res = 0;
        for (; x != 0 || x / 10 != 0; x /= 10) {
            System.out.println("x=" + x);
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            System.out.println("res=" + res);
        }
        return res;
    }
}