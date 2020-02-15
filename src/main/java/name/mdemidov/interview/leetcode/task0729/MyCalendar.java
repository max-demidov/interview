package name.mdemidov.interview.leetcode.task0729;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-i/
 *
 * 729. My Calendar I
 *
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event
 * will not cause a double booking.
 *
 * Your class will have the method, book(int start, int end). Formally, this represents a booking
 * on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * A double booking happens when two events have some non-empty intersection (ie., there is some
 * time that is common to both events.)
 *
 * For each call to the method MyCalendar.book, return true if the event can be added to the
 * calendar successfully without causing a double booking. Otherwise, return false and do not add
 * the event to the calendar.
 *
 * Your class will be called like this:
 * MyCalendar cal = new MyCalendar();
 * MyCalendar.book(start, end)
 *
 * Example 1:
 *
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 *
 * Explanation:
 * The first event can be booked.
 * The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not
 * including 20.
 *
 * Note:
 *
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class MyCalendar {

//    Solution with Runtime: 183 ms, faster than 6.85%
//
//    private Set<Interval> occupied;
//
//    public MyCalendar() {
//        occupied = new HashSet<>();
//    }
//
//    public boolean book(int start, int end) {
//        Interval interval = new Interval(start, end);
//        for (Interval i : occupied) {
//            if (interval.overlaps(i)) {
//                return false;
//            }
//        }
//        occupied.add(interval);
//        return true;
//    }
//
//    private class Interval {
//
//        int start;
//        int end;
//
//        private Interval(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        private boolean overlaps(Interval another) {
//            return another.end > this.start && another.start < this.end;
//        }
//    }

//    Solution with Runtime: 23 ms
    private TreeMap<Integer, Integer> occupied; // <start, end>

    public MyCalendar() {
        occupied = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer closestStart = occupied.floorKey(start);
        Integer closestEnd = occupied.ceilingKey(start);
        if (closestStart != null && occupied.get(closestStart) > start
            || closestEnd != null && closestEnd < end) {
            return false;
        }
        occupied.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar cal = new MyCalendar();
        System.out.println(cal.book(10, 20)); // true
        System.out.println(cal.book(15, 25)); // false
        System.out.println(cal.book(20, 30)); // true
    }
}
