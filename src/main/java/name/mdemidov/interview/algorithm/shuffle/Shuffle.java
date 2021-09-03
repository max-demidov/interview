package name.mdemidov.interview.algorithm.shuffle;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a program that will shuffle through the song names from the library and print them in
 * random order. Each song shall be returned only once.
 *
 * <p>Ideas to consider: Do you want to
 * <li>(a) randomize the values of the array in a new array and print them out or do you want to
 * <li>(b) randomly pick values from the original array, check if they did not repeat and print them
 *     out one after another?
 */
public class Shuffle {
  public static void shuffle(int[] arr) {
    Random random = new Random();
    for (int i = arr.length - 1; i >= 0; i--) {
      int r = random.nextInt(i + 1);
      int swap = arr[i];
      arr[i] = arr[r];
      arr[r] = swap;
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    shuffle(arr);
    System.out.println(Arrays.toString(arr));
  }
}
