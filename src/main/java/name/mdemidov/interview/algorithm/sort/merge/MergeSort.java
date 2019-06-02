package name.mdemidov.interview.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {38, 12, 27, 11, 43, 13, 3, 5, 9, 6, 82, 7, 10};
        System.out.println("Input: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    /**
     * Sorts an array using Merge Sort algorithm.
     */
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Sorts subarray arr[l..r] using merge().
     */
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m].
     * Second subarray is arr[m+1..r]
     */
    private static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays and copy data
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        // Merge the temp arrays
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
