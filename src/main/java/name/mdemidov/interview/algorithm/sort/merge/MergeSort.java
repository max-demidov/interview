package name.mdemidov.interview.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {38, 12, 82, 27, 11, 43, 13, 3, 5, 9, 6, 82, 7, 3, 10};
        System.out.println("Input:  " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    /**
     * Sorts an array using Merge Sort algorithm.
     */
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    /**
     * Sorts subarray arr[l..r-1] using merge().
     */
    private static void sort(int[] arr, int l, int r) {
        if (r - l < 2) {
            return;
        }
        int m = (l + r) / 2;
        sort(arr, l, m);
        sort(arr, m, r);
        merge(arr, l, m, r);
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m-1].
     * Second subarray is arr[m..r]
     */
    private static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l;
        int n2 = r - m;

        // Create temp arrays and copy data
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + i];
        }

        // Merge the temp arrays
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            arr[k++] = L[i] < R[j] ? L[i++] : R[j++];
        }

        // Copy remaining elements if any
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
