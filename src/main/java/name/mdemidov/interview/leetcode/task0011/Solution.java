package name.mdemidov.interview.leetcode.task0011;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        //System.out.println(new Solution().maxArea(new int[]{1, 2, 4, 3}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            //System.out.println("left=" + left + ", right=" + right);
            int candidate = Math.min(height[left], height[right]) * (right - left);
            if (candidate > max) {
                max = candidate;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
