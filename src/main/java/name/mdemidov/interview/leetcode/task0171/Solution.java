package name.mdemidov.interview.leetcode.task0171;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("AJHX"));
    }

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(s.length() - i - 1) - 64;
            res += num * Math.pow(26, i);
        }
        return res;
    }
}
