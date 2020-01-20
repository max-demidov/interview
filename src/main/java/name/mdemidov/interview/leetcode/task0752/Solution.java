package name.mdemidov.interview.leetcode.task0752;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/open-the-lock/
 *
 * 752. Open the Lock
 *
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around:
 * for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be
 * "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 *
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 *
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 *
 * Example 4:
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 *
 * Note:
 * The length of deadends will be in the range [1, 500].
 * target will not be in the list deadends.
 * Every string in deadends and the string target will be a string of 4 digits from the 10,000
 * possibilities '0000' to '9999'.
 */
public class Solution {

    private static final Solution S = new Solution();

    private class Wheel {

        private int value;

        private Wheel(int value) {
            this.value = value % 10;
        }

        private Wheel up() {
            return new Wheel((value + 1) % 10);
        }

        private Wheel down() {
            return new Wheel((value + 9) % 10);
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Wheel wheel = (Wheel) o;

            return value == wheel.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    private class Code {

        private Wheel w1;
        private Wheel w2;
        private Wheel w3;
        private Wheel w4;

        private Code(String str) {
            this(
                Character.getNumericValue(str.charAt(0)),
                Character.getNumericValue(str.charAt(1)),
                Character.getNumericValue(str.charAt(2)),
                Character.getNumericValue(str.charAt(3))
            );
        }

        private Code(int i1, int i2, int i3, int i4) {
            this(new Wheel(i1), new Wheel(i2), new Wheel(i3), new Wheel(i4));
        }

        private Code(Wheel w1, Wheel w2, Wheel w3, Wheel w4) {
            this.w1 = w1;
            this.w2 = w2;
            this.w3 = w3;
            this.w4 = w4;
        }

        private List<Code> movements() {
            List<Code> movements = new ArrayList<>(8);
            movements.add(new Code(w1.up(), w2, w3, w4));
            movements.add(new Code(w1, w2.up(), w3, w4));
            movements.add(new Code(w1, w2, w3.up(), w4));
            movements.add(new Code(w1, w2, w3, w4.up()));
            movements.add(new Code(w1.down(), w2, w3, w4));
            movements.add(new Code(w1, w2.down(), w3, w4));
            movements.add(new Code(w1, w2, w3.down(), w4));
            movements.add(new Code(w1, w2, w3, w4.down()));
            return movements;
        }

        @Override
        public String toString() {
            return String.format("%s%s%s%s", w1, w2, w3, w4);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Code code = (Code) o;

            if (w1 != null ? !w1.equals(code.w1) : code.w1 != null) {
                return false;
            }
            if (w2 != null ? !w2.equals(code.w2) : code.w2 != null) {
                return false;
            }
            if (w3 != null ? !w3.equals(code.w3) : code.w3 != null) {
                return false;
            }
            return w4 != null ? w4.equals(code.w4) : code.w4 == null;
        }

        @Override
        public int hashCode() {
            int result = w1 != null ? w1.hashCode() : 0;
            result = 31 * result + (w2 != null ? w2.hashCode() : 0);
            result = 31 * result + (w3 != null ? w3.hashCode() : 0);
            result = 31 * result + (w4 != null ? w4.hashCode() : 0);
            return result;
        }
    }

    public int openLock(String[] deadends, String target) {
        Code s = new Code("0000");
        Code t = new Code(target);
        Set<Code> d = new HashSet<>();
        for (String dead : deadends) {
            if (dead.equals("0000")) {
                return -1;
            }
            d.add(new Code(dead));
        }

        Queue<Code> q = new LinkedList<>();
        q.offer(s);
        int turns = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Code c = q.poll();
                if (c.equals(t)) {
                    return turns;
                }
                d.add(c);
                for (Code m : c.movements()) {
                    if (d.contains(m)) {
                        continue;
                    }
                    q.offer(m);
                    d.add(m);
                }
            }
            turns++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] d1 = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(S.openLock(d1, "0202"));

        String[] d2 = {"8888"};
        System.out.println(S.openLock(d2, "0009"));

        String[] d3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(S.openLock(d3, "8888"));

        String[] d4 = {"0000"};
        System.out.println(S.openLock(d4, "8888"));
    }
}
