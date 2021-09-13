package name.mdemidov.interview.leetcode.task0394;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * <p>394. Decode String
 *
 * <p>Given an encoded string, return its decoded string.
 *
 * <p>The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * <p>You may assume that the input string is always valid; No extra white spaces, square brackets
 * are well-formed, etc.
 *
 * <p>Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * <p>Example 1:
 *
 * <p>Input: s = "3[a]2[bc]"
 *
 * <p>Output: "aaabcbc"
 *
 * <p>Example 2:
 *
 * <p>Input: s = "3[a2[c]]"
 *
 * <p>Output: "accaccacc"
 *
 * <p>Example 3:
 *
 * <p>Input: s = "2[abc]3[cd]ef"
 *
 * <p>Output: "abcabccdcdcdef"
 *
 * <p>Example 4:
 *
 * <p>Input: s = "abc3[cd]xyz"
 *
 * <p>Output: "abccdcdcdxyz"
 */
public class Solution {

  private static final Solution S = new Solution();

  private int i = 0;

  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    int n = 0;
    while (i < s.length()) {
      char c = s.charAt(i++);
      if (Character.isDigit(c)) {
        n = 10 * n + c - '0';
      } else if (c == '[') {
        sb.append(decodeString(s).repeat(n));
        n = 0;
      } else if (c == ']') {
        break;
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().decodeString("3[a]2[bc]")); // "aaabcbc"
    System.out.println(new Solution().decodeString("3[a2[c]]")); // "accaccacc"
    System.out.println(new Solution().decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
    System.out.println(new Solution().decodeString("abc3[cd]xyz")); // "abccdcdcdxyz"
  }
}
