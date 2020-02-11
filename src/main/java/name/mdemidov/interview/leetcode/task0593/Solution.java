package name.mdemidov.interview.leetcode.task0593;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-square/
 *
 * 593. Valid Square
 *
 * Given the coordinates of four points in 2D space, return whether the four points could construct
 * a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 *
 * Note:
 *
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree
 * angles).
 * Input points have no order.
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> distances = new HashSet<>();
        distances.add(squaredDistance(p1, p2));
        distances.add(squaredDistance(p1, p3));
        distances.add(squaredDistance(p1, p4));
        distances.add(squaredDistance(p2, p3));
        distances.add(squaredDistance(p2, p4));
        distances.add(squaredDistance(p3, p4));
        return distances.size() == 2 && !distances.contains(0);
    }

    private static int squaredDistance(int[] from, int[] to) {
        int d0 = from[0] - to[0];
        int d1 = from[1] - to[1];
        return (d0 * d0) + (d1 * d1);
    }

    public static void main(String[] args) {
        System.out.println(S.validSquare(
            new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1})
        );
    }
}
