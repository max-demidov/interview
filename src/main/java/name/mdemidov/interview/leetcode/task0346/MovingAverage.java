package name.mdemidov.interview.leetcode.task0346;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * <p>
 * 346. Moving Average from Data Stream
 * <p>
 * Given a stream of integers and a window size, calculate the moving average of all integers in the
 * sliding window.
 * <p>
 * Example:
 * <pre>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * </pre>
 */
public class MovingAverage {

  private int size;
  private int sum;
  private Queue<Integer> queue;

  public MovingAverage(int size) {
    this.size = size;
    sum = 0;
    queue = new LinkedList<>();
  }

  public double next(int val) {
    queue.offer(val);
    if (queue.size() > size) {
      sum -= queue.poll();
    }
    sum += val;
    return (double) sum / queue.size();
  }

  public static void main(String[] args) {
    MovingAverage m = new MovingAverage(3);
    System.out.println(m.next(1)); // 1
    System.out.println(m.next(10)); // 5.5
    System.out.println(m.next(3)); // 4.66667
    System.out.println(m.next(5)); // 6
  }
}
