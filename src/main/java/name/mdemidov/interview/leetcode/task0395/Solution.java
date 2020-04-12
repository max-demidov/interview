package name.mdemidov.interview.leetcode.task0395;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * 395. Longest Substring with At Least K Repeating Characters
 *
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            f.put(c, f.getOrDefault(c, 0) + 1);
        }

        Map.Entry<Character, Integer>
            entry =
            f.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get();
        if (entry.getValue() >= k) {
            return s.length();
        }

        String[] substrings = s.split(String.valueOf(entry.getKey()));
        int max = 0;
        for (String substring : substrings) {
            max = Math.max(max, longestSubstring(substring, k));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(S.longestSubstring("aaabb", 3)); // 3
        System.out.println(S.longestSubstring("ababbc", 2)); // 5
    }
}
