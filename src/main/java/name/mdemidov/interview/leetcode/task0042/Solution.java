package name.mdemidov.interview.leetcode.task0042;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * <p>
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * <pre>
 *        #
 *    #~~~##~#
 *  #~##~######
 * </pre>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units
 * of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>
 * Output: 6
 */
public class Solution {

  private static final Solution S = new Solution();

  public int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int sum = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      sum += (leftMax < rightMax ? leftMax - height[left++] : rightMax - height[right--]);
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(S.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    System.out.println(S.trap(new int[]{2, 2, 0, 2, 2})); // 2
    System.out.println(S.trap(new int[]{5, 4, 1, 2})); // 1
    System.out.println(S.trap(new int[]{5, 2, 1, 2, 1, 5})); // 14
  }
}
