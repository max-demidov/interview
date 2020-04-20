package name.mdemidov.interview.leetcode.task0326;

/**
 * 326. Power of Three
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27
 * Output: true
 *
 * Example 2:
 * Input: 0
 * Output: false
 *
 * Example 3:
 * Input: 9
 * Output: true
 *
 * Example 4:
 * Input: 45
 * Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(Integer.MAX_VALUE));
        System.out.println(new Solution().isPowerOfThree(3 * 3 * 3 * 3 * 3 * 3));
    }

    public boolean isPowerOfThree(int n) {
        //return n == 1 || n % 3 < 1 && isPowerOfThree(n / 3);
        if (n == 1) {
            return true;
        }
        int m = 1;
        while (m < n && m > 0) {
            m *= 3;
        }
        return m == n;
    }

}
