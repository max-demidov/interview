package name.mdemidov.interview.leetcode.task0139;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 *
 * 139. Word Break
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.removeIf(w -> !s.contains(w));
        boolean[] cut = new boolean[s.length() + 1];
        cut[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (cut[j] && wordDict.contains(s.substring(j, i))) {
                    cut[i] = true;
                    //System.out.println(Arrays.toString(cut));
                }
            }
        }

        return cut[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(S.wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(S.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(
            S.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println(S.wordBreak("cars", Arrays.asList("car", "ca", "rs"))); // true
    }
}
