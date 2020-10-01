package name.mdemidov.interview.algorithm.binarysearch;

public class BinarySearch {

  public static void main(String[] args) {
    System.out.println(search(new int[] {3, 5, 6, 7, 9, 10, 11, 12, 13, 27, 38, 43, 82}, 12));
  }

  public static int search(int[] arr, int x) {
    return search(arr, 0, arr.length, x);
  }

  private static int search(int[] arr, int l, int r, int x) {
    if (l > r) {
      return -1;
    }
    int m = (l + r) / 2;
    if (arr[m] == x) {
      return m;
    }
    return arr[m] > x ? search(arr, l, m - 1, x) : search(arr, m + 1, r, x);
  }
}
