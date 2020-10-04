package name.mdemidov.interview.leetcode.task0076;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * <p>76. Minimum Window Substring
 *
 * <p>Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * <p>Example:
 *
 * <p>Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 *
 * <p>Note:
 *
 * <p>If there is no such window in S that covers all characters in T, return the empty string "".
 *
 * <p>If there is such window, you are guaranteed that there will always be only one unique minimum
 * window in S.
 */
public class Solution {
  private static final Solution S = new Solution();

  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int min = Integer.MAX_VALUE;
    int minL = 0;
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      char c = s.charAt(r);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
      }
      while (map.values().stream().noneMatch(v -> v > 0)) {
        if (r - l + 1 < min) {
          minL = l;
          min = r - l + 1;
        }
        c = s.charAt(l);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        }
        l++;
      }
    }
    return min == Integer.MAX_VALUE ? "" : s.substring(minL, minL + min);
  }

  public static void main(String[] args) {
    System.out.println(S.minWindow("ADOBECODEBANC", "ABC")); // BANC
  }
}
