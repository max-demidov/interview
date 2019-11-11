package name.mdemidov.interview.util;

import name.mdemidov.interview.algorithm.sort.merge.MergeSort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static void main(String[] args) {
        int[] arr = randomArray(100, 100);
        System.out.println(Arrays.toString(arr));
        Instant start = Instant.now();
        MergeSort.sort(arr);
        Instant finish = Instant.now();
        System.out.println(Arrays.toString(arr));
        System.out.println(Duration.between(start, finish).toMillis() + "ms");
        System.out.println("Is sorted = " + isSorted(arr));
    }

    public static int[] randomArray(int length, int bound) {
        Random r = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = r.nextInt(bound);
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
