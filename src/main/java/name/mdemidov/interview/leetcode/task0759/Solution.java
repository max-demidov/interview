package name.mdemidov.interview.leetcode.task0759;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/employee-free-time/
 *
 * <p>759. Employee Free Time
 *
 * <p>We are given a list schedule of employees, which represents the working time for each
 * employee.
 *
 * <p>Each employee has a list of non-overlapping Intervals, and these intervals are in sorted
 * order.
 *
 * <p>Return the list of finite intervals representing common, positive-length free time for all
 * employees, also in sorted order.
 *
 * <p>(Even though we are representing Intervals in the form [x, y], the objects inside are
 * Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2,
 * and schedule[0][0][0] is not defined). Also, we wouldn't include intervals like [5, 5] in our
 * answer, as they have zero length.
 *
 * <p>Example 1:
 *
 * <pre>
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * </pre>
 *
 * <p>Example 2:
 *
 * <pre>
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 * </pre>
 *
 * Constraints:
 *
 * <p>1 <= schedule.length , schedule[i].length <= 50
 *
 * <p>0 <= schedule[i].start < schedule[i].end <= 10^8
 */
public class Solution {
  private static final Solution S = new Solution();

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> intervals = new ArrayList<>();
    for (List<Interval> list : schedule) {
      intervals.addAll(list);
    }
    intervals.sort(Comparator.comparingInt(i -> i.start));

    int maxEnd = Integer.MIN_VALUE;
    for (Interval i : intervals) {
      maxEnd = Math.max(maxEnd, i.end);
    }

    Set<Integer> ends = new TreeSet<>();
    for (Interval i : intervals) {
      if (i.end < maxEnd) {
        ends.add(i.end);
      }
    }

    List<Interval> res = new ArrayList<>();
    for (int end : ends) {
      if (isBusy(end, intervals)) {
        continue;
      }
      res.add(new Interval(end, nextStart(end, intervals)));
    }

    return res;
  }

  private static boolean isBusy(int end, List<Interval> intervals) {
    for (Interval i : intervals) {
      if (i.start <= end && end < i.end) {
        return true;
      }
    }
    return false;
  }

  private static int nextStart(int end, List<Interval> intervals) {
    for (Interval i : intervals) {
      if (i.start > end) {
        return i.start;
      }
    }
    return -1;
  }

  private static final class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }

    @Override
    public String toString() {
      return String.format("[%d,%d]", start, end);
    }
  }

  public static void main(String[] args) {
    System.out.println(
        S.employeeFreeTime(
            Arrays.asList(
                Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                Arrays.asList(new Interval(1, 3)),
                Arrays.asList(new Interval(4, 10))))); // [[3,4]]

    System.out.println(
        S.employeeFreeTime(
            Arrays.asList(
                Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                Arrays.asList(new Interval(2, 4)),
                Arrays.asList(new Interval(2, 5), new Interval(9, 12))))); // [[5,6],[7,9]]
  }
}
