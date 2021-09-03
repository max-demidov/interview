package name.mdemidov.interview.algorithm.binarysearch;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {3, 5, 6, 7, 9, 10, 11, 12, 13, 27, 38, 43, 82};
    IntStream.of(arr).forEach(i -> System.out.println(search(arr, i)));
    System.out.println(search(arr, 2)); // -1
    System.out.println(search(arr, 8)); // -1
    System.out.println(search(arr, 83)); // -1
  }

  public static int search(int[] arr, int x) {
    return search(arr, 0, arr.length, x);
  }

  private static int search(int[] arr, int l, int r, int x) {
    if (l >= r) {
      return -1;
    }
    int m = (l + r) / 2;
    if (x == arr[m]) {
      return m;
    }
    return x < arr[m] ? search(arr, l, m, x) : search(arr, m + 1, r, x);
  }
}
