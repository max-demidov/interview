package name.mdemidov.interview.interview20210521;

import java.util.HashMap;
import java.util.Map;

/**
 * Array of integers. Print the number and count number of repeat each of them.
 */
public class Task {
  private static int[] arr = {1, 5, 11, 4, 5, 11, 12};

  public static void main(String[] args) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int i : arr) {
      counts.put(i, counts.getOrDefault(i, 0) + 1);
    }
    System.out.println(counts);
  }
}
