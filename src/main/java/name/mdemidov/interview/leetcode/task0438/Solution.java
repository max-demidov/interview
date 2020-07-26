package name.mdemidov.interview.leetcode.task0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 438. Find All Anagrams in a String
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input: s: "cbaebabacd" p: "abc"
 * <p>
 * Output: [0, 6]
 * <p>
 * Explanation:
 * <p>
 * The substring with start index = 0 is "cba", which is an anagram of "abc". The substring with
 * start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * <p>
 * Input: s: "abab" p: "ab"
 * <p>
 * Output: [0, 1, 2]
 * <p>
 * Explanation:
 * <p>
 * The substring with start index = 0 is "ab", which is an anagram of "ab". The substring with start
 * index = 1 is "ba", which is an anagram of "ab". The substring with start index = 2 is "ab", which
 * is an anagram of "ab".
 */
public class Solution {

  private static final Solution S = new Solution();

  public List<Integer> findAnagrams(String s, String p) {
    int sLen = s.length();
    int pLen = p.length();
    int[] S = new int[26];
    int[] P = new int[26];
    for (char c : p.toCharArray()) {
      P[c - 'a']++;
    }

    List<Integer> res = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (j < sLen) {
      S[s.charAt(j) - 'a']++;
      if (j - i >= pLen - 1) {
        if (Arrays.equals(S, P)) {
          res.add(i);
        }
        S[s.charAt(i++) - 'a']--;
      }
      j++;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(S.findAnagrams("cbaebabacd", "abc")); // [0, 6]
    System.out.println(S.findAnagrams("abab", "ab")); // [0, 1, 2]
  }
}
