package name.mdemidov.interview.leetcode.task1170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * 1170. Compare Strings by Frequency of the Smallest Character
 *
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the
 * smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character
 * is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i]
 * is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 *
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa")
 * and f("aaaa") are both > f("cc").
 *
 * Constraints:
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */
public class Solution {

    public static void main(String[] args) {
        print(new String[]{"cbd"}, new String[]{"zaaaz"}); // [1]
        print(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"}); // [1,2]
        print(
            new String[]{"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba",
                         "baabbbaaaa", "babaa", "bbbbabaa"},
            new String[]{"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb",
                         "aabbbabb", "aab", "bbaaababba", "baaaaa"}
        ); // [6,5,0,6,11,11,11,8,11,0,6,6]
    }

    private static void print(String[] queries, String[] words) {
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(queries, words)));
    }

    private static int f(String s) {
        int res = 0;
        char c = 'z' + 1;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == c) {
                res++;
            }
            if (tmp < c) {
                c = tmp;
                res = 1;
            }
        }
        return res;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] w = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        Arrays.sort(w);

        List<Integer> q = new ArrayList<>();
        for (String s : queries) {
            int f = f(s);
            int count = 0;
            for (int i : w) {
                if (f < i) {
                    count++;
                }
            }
            q.add(count);
        }
        return q.stream().mapToInt(i -> i).toArray();
    }

}
