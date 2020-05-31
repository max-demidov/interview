package name.mdemidov.interview.leetcode.task0953;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * <p>
 * 953. Verifying an Alien Dictionary
 * <p>
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a
 * different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return
 * true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz" Output: true
 * <p>
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz" Output: false
 * <p>
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the
 * sequence is unsorted.
 * <p>
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz" Output: false
 * <p>
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as
 * the blank character which is less than any other character (More info).
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * <p>
 * 1 <= words[i].length <= 20
 * <p>
 * order.length == 26
 * <p>
 * All characters in words[i] and order are English lowercase letters.
 */
public class Solution {

  private static final Solution S = new Solution();

  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>(order.length());
    for (int i = 0; i < order.length(); i++) {
      map.put(order.charAt(i), i);
    }
    for (int i = 1; i < words.length; i++) {
      String prev = words[i - 1];
      String cur = words[i];
      int min = Math.min(prev.length(), cur.length());
      int j = 0;
      while (j <= min) {
        int a = j < prev.length() ? map.get(prev.charAt(j)) : -1;
        int b = j < cur.length() ? map.get(cur.charAt(j)) : -1;
        if (a < b) {
          break;
        }
        if (a > b) {
          //System.out.printf("prev=%s, cur=%s, j=%d, a=%d, b=%d%n", prev, cur, j, a, b);
          return false;
        }
        j++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out
        .println(S.isAlienSorted(new String[]{"hello", "leetcode"},
            "hlabcdefgijkmnopqrstuvwxyz")); // true
    System.out
        .println(S.isAlienSorted(new String[]{"word", "world", "row"},
            "worldabcefghijkmnpqstuvxyz")); // false
    System.out
        .println(S.isAlienSorted(new String[]{"apple", "app"},
            "abcdefghijklmnopqrstuvwxyz")); // false
  }
}
