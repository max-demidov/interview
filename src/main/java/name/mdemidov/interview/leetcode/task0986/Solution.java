package name.mdemidov.interview.leetcode.task0986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 * <p>
 * 986. Interval List Intersections
 * <p>
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted
 * order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x
 * <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or
 * can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is
 * [2, 3].)
 * <p>
 * Input:
 * <p>
 * A = [[0,2],[5,10],[13,23],[24,25]],
 * <p>
 * B = [[1,5],[8,12],[15,24],[25,26]]
 * <p>
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * Note:
 * <p>
 * 0 <= A.length < 1000
 * <p>
 * 0 <= B.length < 1000
 * <p>
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class Solution {

  private static final Solution S = new Solution();

  public int[][] intervalIntersection(int[][] A, int[][] B) {
    int a = 0;
    int b = 0;
    List<int[]> res = new ArrayList<>();
    while (a < A.length && b < B.length) {
      int[] i = intersection(A[a], B[b]);
      if (i != null) {
        res.add(i);
      }
      if (a < A.length - 1 && A[a + 1][0] <= B[b][1]) {
        a++;
      } else if (b < B.length - 1 && B[b + 1][0] <= A[a][1]) {
        b++;
      } else {
        a++;
        b++;
      }
    }
    return res.toArray(new int[0][]);
  }

  private static int[] intersection(int[] A, int[] B) {
    if (A[0] <= B[0] && B[0] <= A[1]) {
      return new int[]{B[0], Math.min(A[1], B[1])};
    }
    if (B[0] <= A[0] && A[0] <= B[1]) {
      return new int[]{A[0], Math.min(A[1], B[1])};
    }
    return null;
  }

  public static void main(String[] args) {
    int[][] a1 = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] b1 = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
    print(S.intervalIntersection(a1, b1)); // [1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]

    int[][] a2 = new int[][]{{8, 15}};
    int[][] b2 = new int[][]{{2, 6}, {8, 10}, {12, 20}};
    print(S.intervalIntersection(a2, b2)); // [8,10], [12,15]

    int[][] a3 = new int[][]{};
    int[][] b3 = new int[][]{};
    print(S.intervalIntersection(a3, b3)); // []

    int[][] a4 = new int[][]{{4, 11}};
    int[][] b4 = new int[][]{{1, 2}, {8, 11}, {12, 13}, {14, 15}, {17, 19}};
    print(S.intervalIntersection(a4, b4)); // [8,11]

    int[][] a5 = new int[][]{{2, 3}, {4, 6}, {7, 9}, {10, 16}, {17, 20}};
    int[][] b5 = new int[][]{{1, 3}, {4, 7}, {10, 11}, {15, 18}};
    print(S.intervalIntersection(a5, b5)); // [2,3],[4,6],[7,7],[10,11],[15,16],[17,18]
  }

  private static void print(int[][] a) {
    System.out.println(Stream.of(a).map(Arrays::toString).collect(Collectors.joining(", ")));
  }
}
