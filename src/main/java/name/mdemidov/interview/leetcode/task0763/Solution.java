package name.mdemidov.interview.leetcode.task0763;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * <p>
 * 763. Partition Labels
 * <p>
 * A string S of lowercase English letters is given. We want to partition this string into as many
 * parts as possible so that each letter appears in at most one part, and return a list of integers
 * representing the size of these parts.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ababcbacadefegdehijhklij"
 * <p>
 * Output: [9,7,8]
 * <p>
 * Explanation:
 * <p>
 * The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that each letter
 * appears in at most one part. A partition like "ababcbacadefegde", "hijhklij" is incorrect,
 * because it splits S into less parts.
 * <p>
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * <p>
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class Solution {

  private static final Solution S = new Solution();

  public List<Integer> partitionLabels(String S) {
    List<Integer> res = new ArrayList<>();
    int i = -1;
    int j;
    int last = -1;
    while (++i < S.length()) {
      j = S.lastIndexOf(S.charAt(i));
      while (i < j) {
        j = Math.max(j, S.lastIndexOf(S.charAt(i++)));
      }
      res.add(j - last);
      last = j;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(S.partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]
  }
}
