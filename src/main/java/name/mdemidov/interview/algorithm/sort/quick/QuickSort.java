package name.mdemidov.interview.algorithm.sort.quick;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {38, 12, 27, 11, 43, 13, 3, 5, 9, 6, 82, 7, 10};
        System.out.println("Input: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    /**
     * Sorts an array using Quick Sort algorithm.
     */
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Sorts subarray arr[low..high] using partition().
     *
     * @param arr  - array to be sorted
     * @param low  - starting index
     * @param high - ending index
     */
    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        // pi is partitioning index, arr[pi] is now at right place
        int pi = partition(arr, low, high);

        // Recursively sort elements before partition and after partition
        sort(arr, low, pi - 1);
        sort(arr, pi + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j <= high; j++) {
            if (arr[j] > pivot) {
                continue;
            }

            // swap arr[i] and arr[j]
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            i++;
        }

        return i - 1;
    }
}
