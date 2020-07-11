package name.mdemidov.interview.leetcode.task1249;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * <p>
 * 1249. Minimum Remove to Make Valid Parentheses
 * <p>
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
 * the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * <p>
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * <p>
 * It can be written as (A), where A is a valid string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * <p>
 * Output: "lee(t(c)o)de"
 * <p>
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * <p>
 * Output: "ab(c)d"
 * <p>
 * Example 3:
 * <p>
 * Input: s = "))(("
 * <p>
 * Output: ""
 * <p>
 * Explanation: An empty string is also valid.
 * <p>
 * Example 4:
 * <p>
 * Input: s = "(a(b(c)d)"
 * <p>
 * Output: "a(b(c)d)"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * <p>
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class Solution {

  private static final Solution S = new Solution();

  public String minRemoveToMakeValid(String s) {
    StringBuilder sb = new StringBuilder();
    int open = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        open++;
      }
      if (s.charAt(i) == ')') {
        open--;
      }
      if (open < 0) {
        open = 0;
      } else {
        sb.append(s.charAt(i));
      }
    }
    s = sb.toString();
    sb = new StringBuilder();
    open = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ')') {
        open++;
      }
      if (s.charAt(i) == '(') {
        open--;
      }
      if (open < 0) {
        open = 0;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(S.minRemoveToMakeValid("lee(t(c)o)de)")); // "lee(t(c)o)de"
    System.out.println(S.minRemoveToMakeValid("a)b(c)d")); // "ab(c)d"
    System.out.println(S.minRemoveToMakeValid("))((")); // ""
    System.out.println(S.minRemoveToMakeValid("(a(b(c)d)")); // "a(b(c)d)"
    System.out.println(S.minRemoveToMakeValid("())()(((")); // "()()"
  }
}
