package name.mdemidov.interview.leetcode.task0207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0
 * you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                return false;
            }
        }
        return true;
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
        System.out.println(S.canFinish(2, new int[][]{{1, 0}})); // true
        System.out.println(S.canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false
    }
}
