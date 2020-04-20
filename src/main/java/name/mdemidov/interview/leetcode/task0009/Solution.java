package name.mdemidov.interview.leetcode.task0009;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int tmp = x;
        for (; tmp > 0; tmp /= 10) {
            reverse = reverse * 10 + tmp % 10;
        }
        return (x == reverse);
    }
}