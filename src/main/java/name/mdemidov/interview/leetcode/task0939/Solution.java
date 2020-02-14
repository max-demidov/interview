package name.mdemidov.interview.leetcode.task0939;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 *
 * 939. Minimum Area Rectangle
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle
 * formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 * Note:
 *
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xMap = new HashMap<>();
        for (int[] p : points) {
            xMap.putIfAbsent(p[0], new HashSet<>());
            xMap.get(p[0]).add(p[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (xMap.get(p1[0]).contains(p2[1]) && xMap.get(p2[0]).contains(p1[1])) {
                    minArea = Math.min(minArea, area(p1, p2));
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private static int area(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        System.out.println(S.minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}})); // 4
        System.out.println(
            S.minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}})); // 2
    }
}
