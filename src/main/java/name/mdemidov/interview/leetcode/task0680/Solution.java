package name.mdemidov.interview.leetcode.task0680;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * <p>
 * 680. Valid Palindrome II
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a
 * palindrome.
 * <p>
 * Example 1: Input: "aba" Output: True
 * <p>
 * Example 2: Input: "abca" Output: True Explanation: You could delete the character 'c'.
 * <p>
 * Note: The string will only contain lowercase characters a-z. The maximum length of the string is
 * 50000.
 */
public class Solution {

  public static final Solution S = new Solution();

  public boolean validPalindrome(String s) {
    int[] indexes = indexes(s, 0, s.length() - 1);
    return indexes.length < 1
        || indexes(s, indexes[0] + 1, indexes[1]).length < 1
        || indexes(s, indexes[0], indexes[1] - 1).length < 1;
  }

  private static int[] indexes(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return new int[]{l, r};
      }
      l++;
      r--;
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    System.out.println(S.validPalindrome("a")); // true
    System.out.println(S.validPalindrome("aa")); // true
    System.out.println(S.validPalindrome("ab")); // true
    System.out.println(S.validPalindrome("aba")); // true
    System.out.println(S.validPalindrome("abab")); // true
    System.out.println(S.validPalindrome("abba")); // true
    System.out.println(S.validPalindrome("abca")); // true
    System.out.println(S.validPalindrome("ababa")); // true
    System.out.println(S.validPalindrome("abasa")); // false
    System.out.println(S.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqnc"
        + "ffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga")); // true
  }
}
