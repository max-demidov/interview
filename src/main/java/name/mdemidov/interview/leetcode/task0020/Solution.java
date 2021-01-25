package name.mdemidov.interview.leetcode.task0020;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid. An input string is valid if: 1. Open brackets must be closed by the same
 * type of brackets. 2. Open brackets must be closed in the correct order. Note that an empty string
 * is also considered valid.
 */
public class Solution {

  private static final Solution S = new Solution();

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '(') {
        stack.push(')');
      } else {
        if (stack.isEmpty() || c != stack.pop()) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(S.isValid("()")); // true
    System.out.println(S.isValid("()[]{}")); // true
    System.out.println(S.isValid("(]")); // false
    System.out.println(S.isValid("([)]")); // false
    System.out.println(S.isValid("{[]}")); // true
    System.out.println(S.isValid("]")); // false
  }
}
