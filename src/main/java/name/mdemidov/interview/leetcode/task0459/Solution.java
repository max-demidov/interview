package name.mdemidov.interview.leetcode.task0459;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * 459. Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and
 * appending multiple copies of the substring together. You may assume the given string consists
 * of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 2; i <= length; i++) {
            if (length % i > 0) {
                continue;
            }
            int l = length / i;
            String str = s.substring(0, l);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(str);
            }
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(S.repeatedSubstringPattern("abab"));
        System.out.println(S.repeatedSubstringPattern("aba"));
        System.out.println(S.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(S.repeatedSubstringPattern("bb"));
    }
}
