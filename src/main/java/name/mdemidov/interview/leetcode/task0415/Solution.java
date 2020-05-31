package name.mdemidov.interview.leetcode.task0415;

/**
 * https://leetcode.com/problems/add-strings/
 * <p>
 * 415. Add Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and
 * num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * <p>
 * Both num1 and num2 contains only digits 0-9.
 * <p>
 * Both num1 and num2 does not contain any leading zero.
 * <p>
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution {

  private static final Solution S = new Solution();

  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int l1 = num1.length();
    int l2 = num2.length();
    int max = Math.max(num1.length(), num2.length());
    int t = 0;
    for (int i = 0; i < max; i++) {
      int a = i < l1 ? num1.charAt(l1 - 1 - i) - '0' : 0;
      int b = i < l2 ? num2.charAt(l2 - 1 - i) - '0' : 0;
      int c = a + b + t;
      sb.append(c % 10);
      t = c / 10;
    }
    if (t > 0) {
      sb.append(t);
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(S.addStrings("985", "15")); // 1000
  }
}
