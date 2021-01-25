package name.mdemidov.interview.leetcode.task0007;

public class Solution {

  private static final Solution S = new Solution();

  public int reverse(int x) {
    int res = 0;
    int max = Integer.MAX_VALUE / 10;
    int min = Integer.MIN_VALUE / 10;
    while (x != 0) {
      if (res > max || res < min) {
        return 0;
      }
      res = res * 10 + x % 10;
      x /= 10;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(S.reverse(123)); // 312
    System.out.println(S.reverse(-123)); // -321
    System.out.println(S.reverse(120)); // 21
    System.out.println(S.reverse(0)); // 0
    System.out.println(S.reverse(Integer.MAX_VALUE)); // 0
    System.out.println(S.reverse(Integer.MIN_VALUE)); // 0
  }
}
