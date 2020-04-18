package name.mdemidov.interview.leetcode.task0131;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Solution {

    private static final Solution S = new Solution();

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.isEmpty()) {
            return res;
        }
        partition(s, 0, res, new ArrayList<>());
        return res;
    }

    private static void partition(String s, int start, List<List<String>> res, List<String> cur) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i + 1)) {
                continue;
            }
            cur.add(s.substring(start, i + 1));
            partition(s, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            if (s.charAt(start + i) != s.charAt(end - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(S.partition("aab"));
        System.out.println(S.partition(""));
        System.out.println(S.partition("aaa"));
        System.out.println(S.partition("abba"));
    }
}
