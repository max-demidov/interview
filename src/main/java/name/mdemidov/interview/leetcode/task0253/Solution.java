package name.mdemidov.interview.leetcode.task0253;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * 253. Meeting Rooms II
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class Solution {

    private static final Solution S = new Solution();

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 0;
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[j]) {
                count++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(S.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(S.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }
}
