package name.mdemidov.interview.leetcode.task0692;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * <p>
 * 692. Top K Frequent Words
 * <p>
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same
 * frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * <p>
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * <p>
 * Output: ["i", "love"]
 * <p>
 * Explanation: "i" and "love" are the two most frequent words. Note that "i" comes before "love"
 * due to a lower alphabetical order.
 * <p>
 * Example 2:
 * <p>
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * <p>
 * Output: ["the", "is", "sunny", "day"]
 * <p>
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively.
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * <p>
 * Input words contain only lowercase letters.
 * <p>
 * Follow up:
 * <p>
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class Solution {

  private static final Solution S = new Solution();

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    return map.entrySet().stream().sorted(
        (e1, e2) -> {
          int valDiff = e2.getValue() - e1.getValue();
          return valDiff == 0 ? e1.getKey().compareTo(e2.getKey()) : valDiff;
        }
    ).limit(k).map(Entry::getKey).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(S.topKFrequent(
        new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    System.out.println(S.topKFrequent(
        new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
  }
}
