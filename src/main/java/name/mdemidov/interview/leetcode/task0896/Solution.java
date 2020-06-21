package name.mdemidov.interview.leetcode.task0896;

/**
 * https://leetcode.com/problems/monotonic-array/
 * <p>
 * 896. Monotonic Array
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A is monotone
 * decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3] Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: [6,5,4,4] Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: [1,3,2] Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: [1,2,4,5] Output: true
 * <p>
 * Example 5: Input: [1,1,1] Output: true
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * <p>
 * -100000 <= A[i] <= 100000
 */
public class Solution {

  private static final Solution S = new Solution();

  public boolean isMonotonic(int[] A) {
    return increasing(A) || decreasing(A);
  }

  public boolean increasing(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] > A[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public boolean decreasing(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] < A[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(S.isMonotonic(new int[]{1, 2, 2, 3})); // true
    System.out.println(S.isMonotonic(new int[]{6, 5, 4, 4})); // true
    System.out.println(S.isMonotonic(new int[]{1, 3, 2})); // false
    System.out.println(S.isMonotonic(new int[]{1, 2, 4, 5})); // true
    System.out.println(S.isMonotonic(new int[]{1, 1, 1})); // true
    System.out.println(S.isMonotonic(new int[]{1, 3, 2, 4})); // false
  }
}
