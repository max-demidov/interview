package name.mdemidov.interview.algorithm.random;

import java.util.Arrays;

/** Implement int rand20() that would return a value in range [1,20] using boolean rand(). */
public class RandomInteger {

  public static void main(String[] args) {
    int[] normal = new int[20];
    for (int i = 0; i < 100_000; i++) {
      normal[rand20normal() - 1]++;
    }
    System.out.println("Normal distribution: " + Arrays.toString(normal));

    int[] uniform = new int[20];
    for (int i = 0; i < 100_000; i++) {
      uniform[rand20() - 1]++;
    }
    System.out.println("Uniform distribution: " + Arrays.toString(uniform));
  }

  /**
   * Invalid solution as it provides normal distribution, where the bound values 1 and 20 are
   * returned much rarer (2^-20) than middle ones.
   */
  public static int rand20normal() {
    int res = 1;
    for (int i = 1; i < 20; i++) {
      if (rand()) {
        res++;
      }
    }
    return res;
  }

  public static int rand20() {
    return 1 + rand32() % 20;
  }

  private static int rand32() {
    return rand2() * 16 + rand2() * 8 + rand2() * 4 + rand2() * 2 + rand2();
  }

  private static int rand2() {
    return rand() ? 0 : 1;
  }

  private static boolean rand() {
    return Math.random() < .5;
  }
}
