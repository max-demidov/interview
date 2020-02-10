package name.mdemidov.interview.leetcode.task1197;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-knight-moves/
 *
 * 1197. Minimum Knight Moves
 *
 * In an infinite chess board with coordinates from -infinity to +infinity,
 * you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below.
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y].
 * It is guaranteed the answer exists.
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 *
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 * Constraints:
 * |x| + |y| <= 300
 */
public class Solution {

    private static final Solution S = new Solution();

    private int[][] visited = new int[601][601];

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>(next(0, 0, 1));
        while (!queue.isEmpty() && visited[300 + x][300 + y] < 1) {
            int[] p = queue.poll();
            if (visited[300 + p[0]][300 + p[1]] > 0) {
                continue;
            }
            visited[300 + p[0]][300 + p[1]] = p[2];
            queue.addAll(next(p[0], p[1], p[2] + 1));
        }
        return visited[300 + x][300 + y];
    }

    private static List<int[]> next(int x, int y, int moves) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x + 1, y + 2, moves});
        list.add(new int[]{x + 2, y + 1, moves});
        list.add(new int[]{x + 2, y - 1, moves});
        list.add(new int[]{x + 1, y - 2, moves});
        list.add(new int[]{x - 1, y - 2, moves});
        list.add(new int[]{x - 2, y - 1, moves});
        list.add(new int[]{x - 2, y + 1, moves});
        list.add(new int[]{x - 1, y + 2, moves});
        return list;
    }

    public static void main(String[] args) {
        System.out.println(S.minKnightMoves(2, 1)); // 1
        System.out.println(S.minKnightMoves(5, 5)); // 4
    }

}
