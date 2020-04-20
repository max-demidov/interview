package name.mdemidov.interview.leetcode.task0088;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 2, 3, 7, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{0, 0, 1, 2, 5};
        new Solution().merge(nums1, 5, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums2[j] < tmp[i]) {
                nums1[i+j] = nums2[j];
                j++;
            } else {
                nums1[i+j] = tmp[i];
                i++;
            }
        }
        while (i < m) {
            nums1[i + j] = tmp[i];
            i++;
        }
        while (j < n) {
            nums1[i+j] = nums2[j];
            j++;
        }
    }
}
