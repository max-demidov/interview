package name.mdemidov.interview.leetcode.task0278;

/**
 * https://leetcode.com/problems/first-bad-version/
 * <p>
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed based
 * on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which
 * causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to
 * the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * <p>
 * call isBadVersion(5) -> true
 * <p>
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
public class Solution {

  private static final Solution S = new Solution();

  public int firstBadVersion(int n) {
    return bs(1, n);
  }

  private int bs(long l, long r) {
    //System.out.printf("l=%s, r=%s%n", l, r);
    if (l >= r) {
      return (int) l;
    }
    int m = (int) ((l + r) / 2);
    return isBadVersion(m) ? bs(l, m) : bs(m + 1, r);
  }

  public static void main(String[] args) {
    System.out.println(S.firstBadVersion(2126753390)); // 1702766719
  }

  private boolean isBadVersion(int n) {
    return n >= 1702766719;
  }
}
