package name.mdemidov.interview.leetcode.task0681;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/next-closest-time/
 *
 * 681. Next Closest Time
 *
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the
 * current digits. There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all
 * valid. "1:34", "12:9" are all invalid.
 *
 * Example 1:
 *
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5
 * minutes later. It is not 19:33, because this occurs 23 hours and 59 minutes later.
 *
 * Example 2:
 *
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed
 * that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class Solution {

    private static final Solution S = new Solution();

    public String nextClosestTime(String time) {
        return new Time(time).next().toString();
    }

    private class Time {

        private int h;
        private int m;
        private Set<Integer> digits;

        public Time(String time) {
            h = Integer.valueOf(time.substring(0, 2));
            m = Integer.valueOf(time.substring(3));
            digits = new TreeSet<>();
            digits.add(Character.getNumericValue(time.charAt(0)));
            digits.add(Character.getNumericValue(time.charAt(1)));
            digits.add(Character.getNumericValue(time.charAt(3)));
            digits.add(Character.getNumericValue(time.charAt(4)));
        }

        public Time next() {
            m++;
            if (m > 59) {
                h++;
            }
            m %= 60;
            h %= 24;

            if (digits.contains(h / 10) && digits.contains(h % 10) &&
                digits.contains(m / 10) && digits.contains(m % 10)) {
                return this;
            }
            return next();
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", h, m);
        }
    }

    public static void main(String[] args) {
        System.out.println(S.nextClosestTime("19:34")); // 19:39
        System.out.println(S.nextClosestTime("23:59")); // 22:22
    }
}
