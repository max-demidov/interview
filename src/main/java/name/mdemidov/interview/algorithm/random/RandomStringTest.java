package name.mdemidov.interview.algorithm.random;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.LongStream;

/**
 * How would you test a method that generates random String of fixed length 20 chars which may
 * contain only english letters, digits and spaces.
 */
public class RandomStringTest {

  private static final int LENGTH = 20;
  private static final char[] CHARS;
  private static final Random RANDOM = new Random();

  static {
    int length = 1 + 'Z' - 'A' + 1 + 'z' - 'a' + 1 + '9' - '0' + 1; // + 1 for a space
    CHARS = new char[length];
    int i = 0;
    for (char c = 'A'; c <= 'Z'; c++) {
      CHARS[i++] = c;
    }
    for (char c = 'a'; c <= 'z'; c++) {
      CHARS[i++] = c;
    }
    for (char c = '0'; c <= '9'; c++) {
      CHARS[i++] = c;
    }
    CHARS[i] = ' ';
  }

  public static void main(String[] args) {
    System.out.printf("%nPossible chars in the random String:%n%s%n", Arrays.toString(CHARS));
    System.out.printf("%nRandom string example:%n%s%n", randomString());
    testRandomString();
  }

  public static String randomString() {
    char[] chars = new char[LENGTH];
    for (int i = 0; i < LENGTH; i++) {
      chars[i] = CHARS[RANDOM.nextInt(CHARS.length)];
    }
    return new String(chars);
  }

  public static void testRandomString() {
    int[][] distribution = new int[LENGTH][CHARS.length];
    int n = 100_000;
    long[] nanosElapsed = new long[n];
    for (int i = 0; i < n; i++) {
      long start = System.nanoTime();
      String str = randomString();
      long end = System.nanoTime();
      nanosElapsed[i] = end - start;
      for (int j = 0; j < LENGTH; j++) {
        for (int k = 0; k < CHARS.length; k++) {
          if (CHARS[k] == str.charAt(j)) {
            distribution[j][k]++;
          }
        }
      }
    }

    System.out.println("\nDistribution table (columns - random chars, rows - char index):");
    int expectedUniformDistribution = n / CHARS.length;
    for (int[] row : distribution) {
      System.out.println(Arrays.toString(row));
      for (int cell : row) {
        if (cell < expectedUniformDistribution * .8 || cell > expectedUniformDistribution * 1.2) {
          System.out.printf(
              "Suspicious distribution found: %d, expected: %d%n",
              cell, expectedUniformDistribution);
        }
      }
    }

    System.out.println("\nPerformance data (nanoseconds elapsed on a random String generation):");
    Arrays.sort(nanosElapsed);
    long min = nanosElapsed[0];
    long max = nanosElapsed[nanosElapsed.length - 1];
    long median = nanosElapsed[nanosElapsed.length / 2];
    long avg = (long) LongStream.of(nanosElapsed).average().getAsDouble();
    System.out.printf("\t* min: %d%n", min);
    System.out.printf("\t* max: %d%n", max);
    System.out.printf("\t* average: %d%n", avg);
    System.out.printf("\t* median: %d%n", median);
  }
}
