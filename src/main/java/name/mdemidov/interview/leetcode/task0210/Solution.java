package name.mdemidov.interview.leetcode.task0210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * 210. Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0
 * you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 *
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished
 * both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            if (map.containsKey(p[0])) {
                map.get(p[0]).add(p[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p[1]);
                map.put(p[0], list);
            }
        }
        //System.out.println(map);

        List<Integer> added = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            added = next(i, added, map, 0);
            if (added.isEmpty()) {
                return new int[0];
            }
        }

        //System.out.println(added);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = added.get(i);
        }
        return res;
    }

    private static List<Integer> next(int i, List<Integer> added, Map<Integer, List<Integer>> map,
                                      int n) {
        if (n++ > map.size()) {
            return new ArrayList<>();
        }
        if (added.contains(i)) {
            return added;
        }
        if (!map.containsKey(i)) {
            added.add(i);
            return added;
        }
        List<Integer> list = map.get(i);
        for (int p : list) {
            if (!added.contains(p)) {
                added = next(p, added, map, n);
                if (added.isEmpty()) {
                    return added;
                }
            }
        }
        added.add(i);
        return added;
    }

    public static void main(String[] args) {
        print(2, new int[][]{{1, 0}}); // [0,1]
        print(4, new int[][]{{1, 0}, {2, 0}, {3, 2}, {3, 1}}); // [0,1,2,3] or [0,2,1,3]
        print(2, new int[][]{{1, 0}, {0, 1}}); // []
    }

    private static void print(int n, int[][] p) {
        System.out.println(Arrays.toString(S.findOrder(n, p)));
    }
}
