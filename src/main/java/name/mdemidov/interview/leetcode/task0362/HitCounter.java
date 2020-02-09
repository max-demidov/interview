package name.mdemidov.interview.leetcode.task0362;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/design-hit-counter/
 *
 * 362. Design Hit Counter
 *
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that
 * calls are being made to the system in chronological order (ie, the timestamp is monotonically
 * increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 *
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 */
public class HitCounter {

    private Queue<Integer> hits;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hits = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        //hits.removeIf(h -> timestamp - h >= 300);
        while (!hits.isEmpty() && timestamp - hits.peek() >= 300) {
            hits.poll();
        }
        return hits.size();
    }

    public static void main(String[] args) {
        HitCounter c1 = new HitCounter();
        c1.hit(1);
        c1.hit(2);
        c1.hit(3);
        System.out.println(c1.getHits(4)); // 3
        c1.hit(300);
        System.out.println(c1.getHits(300)); // 4
        System.out.println(c1.getHits(301)); // 3
    }
}
