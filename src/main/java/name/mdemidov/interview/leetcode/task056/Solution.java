package name.mdemidov.interview.leetcode.task056;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class Solution {

    public static void main(String[] args) {
        printMerged(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        printMerged(new int[][]{{1, 4}, {4, 5}});
        printMerged(new int[][]{{1, 4}, {0, 5}});
        printMerged(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});
        printMerged(new int[][]{{2, 3}, {4, 6}, {5, 7}, {3, 4}});
        printMerged(
            new int[][]{{3, 5}, {0, 0}, {4, 4}, {0, 2}, {5, 6}, {4, 5}, {3, 5}, {1, 3}, {4, 6},
                        {4, 6}, {3, 4}});
    }

    private static void printMerged(int[][] array) {
        print(new Solution().merge(array));
    }

    private static void print(int[][] array) {
        for (int[] i : array) {
            System.out.print(Arrays.toString(i));
        }
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i][1]) {
                continue;
            }
            for (int j = 0; j < intervals.length; j++) {
                if (i == j || intervals[j][0] > intervals[j][1]) {
                    continue;
                }
                if (intervals[j][0] < intervals[i][0] && intervals[j][1] > intervals[i][1]) {
                    intervals[i][0] = intervals[j][0];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = 1;
                    intervals[j][1] = 0;
                    i--;
                    break;
                }
                if (intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[j][0] = 1;
                    intervals[j][1] = 0;
                    i--;
                    break;
                }
                if (intervals[j][1] <= intervals[i][1] && intervals[j][1] >= intervals[i][0]) {
                    intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][0] = 1;
                    intervals[j][1] = 0;
                    i--;
                    break;
                }
            }
        }

        int n = 0;
        for (int[] i : intervals) {
            if (i[0] <= i[1]) {
                n++;
            }
        }

        int[][] merged = new int[n][2];
        int i = 0;
        for (int[] interval : intervals) {
            if (interval[0] > interval[1]) {
                continue;
            }
            merged[i++] = interval;
        }
        return merged;
    }
}
