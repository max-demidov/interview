package name.mdemidov.interview.leetcode.task242;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
        System.out.println(new Solution().isAnagram("ac", "bb"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> ss = new HashMap<>();
        for (char c : s.toCharArray()) {
            ss.putIfAbsent(c, 0);
            ss.put(c, ss.get(c) + 1);
        }
        Map<Character, Integer> tt = new HashMap<>();
        for (char c : t.toCharArray()) {
            tt.putIfAbsent(c, 0);
            tt.put(c, tt.get(c) + 1);
        }
        return ss.equals(tt);
    }

}
