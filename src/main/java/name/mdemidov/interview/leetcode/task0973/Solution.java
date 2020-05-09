package name.mdemidov.interview.leetcode.task0973;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * <p>
 * 973. K Closest Points to Origin
 * <p>
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the
 * order that it is in.)
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * <p>
 * Output: [[-2,2]]
 * <p>
 * Explanation: The distance between (1, 3) and the origin is sqrt(10). The distance between (-2, 2)
 * and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin. We only
 * want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * <p>
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * <p>
 * Output: [[3,3],[-2,4]] (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * <p>
 * -10000 < points[i][0] < 10000
 * <p>
 * -10000 < points[i][1] < 10000
 */
public class Solution {

  private static final Solution S = new Solution();

  public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    int[][] res = new int[K][2];
    System.arraycopy(points, 0, res, 0, K);
    return res;
  }

  public static void main(String[] args) {
    print(S.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
    print(S.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
  }

  private static void print(int[][] points) {
    for (int[] point : points) {
      System.out.println(Arrays.toString(point));
    }
  }
}
