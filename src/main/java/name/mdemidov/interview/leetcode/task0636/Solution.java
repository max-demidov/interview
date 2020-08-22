package name.mdemidov.interview.leetcode.task0636;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * <p>
 * 636. Exclusive Time of Functions
 * <p>
 * On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and
 * N-1.
 * <p>
 * We store logs in timestamp order that describe when a function is entered or exited.
 * <p>
 * Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For
 * example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.
 * "1:end:2" means the function with id 1 ended at the end of timestamp 2.
 * <p>
 * A function's exclusive time is the number of units of time spent in this function.  Note that
 * this does not include any recursive calls to child functions.
 * <p>
 * The CPU is single threaded which means that only one function is being executed at a given time
 * unit.
 * <p>
 * Return the exclusive time of each function, sorted by their function id.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * n = 2
 * <p>
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * <p>
 * Output: [3, 4]
 * <p>
 * Explanation:
 * <p>
 * Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the
 * end of time 1. Now function 1 starts at the beginning of time 2, executes 4 units of time and
 * ends at time 5.
 * <p>
 * Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus
 * executing for 1 unit of time. So function 0 spends 2 + 1 = 3 units of total time executing, and
 * function 1 spends 4 units of total time executing.
 * <p>
 * Note:
 * <p>
 * 1 <= n <= 100
 * <p>
 * Two functions won't start or end at the same time.
 * <p>
 * Functions will always log when they exit.
 */
public class Solution {

  private static final Solution S = new Solution();

  public int[] exclusiveTime(int n, List<String> logs) {
    int[] ids = new int[n];

    int lastTs = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    for (String log : logs) {
      String[] args = log.split(":");
      int id = Integer.parseInt(args[0]);
      int ts = Integer.parseInt(args[2]);

      if ("start".equals(args[1])) {
        while (!stack.isEmpty() && ++lastTs < ts) {
          ids[stack.peek()]++;
        }
        ids[id]++;
        stack.push(id);
      } else {
        while (!stack.isEmpty() && ++lastTs <= ts) {
          ids[id]++;
        }
        stack.pop();
      }
      lastTs = ts;
    }
    return ids;
  }

  public static void main(String[] args) {
    List<String> logs1 = Arrays
        .asList("0:start:0", "1:start:2", "2:start:3", "2:end:4", "1:end:7", "0:end:8");
    System.out.println(Arrays.toString(S.exclusiveTime(3, logs1))); // [3, 4, 2]

    List<String> logs2 = Arrays
        .asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
    System.out.println(Arrays.toString(S.exclusiveTime(1, logs2))); // [8]
  }
}
