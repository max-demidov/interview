package name.mdemidov.interview.leetcode.task004;

public class Solution {

    public static void main(String[] args) {
        int[] input1 = {1, 1, 3, 4};
        int[] input2 = {1, 2};
        double output = new Solution().findMedianSortedArrays(input1, input2);
        System.out.println(output);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergeSortedArrays(nums1, nums2);
        int mid = merged.length / 2;
        return (merged.length % 2 > 0) ? merged[mid] : (double) (merged[mid] + merged[mid - 1]) / 2;
    }

    public int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }
        return merged;
    }
}
