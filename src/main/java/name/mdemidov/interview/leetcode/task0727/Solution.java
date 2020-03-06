package name.mdemidov.interview.leetcode.task0727;

/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 *
 * 727. Minimum Window Subsequence
 *
 * Given strings S and T, find the minimum (contiguous) substring W of S,
 * so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If
 * there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * Example 1:
 *
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 *
 * Note:
 *
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 */
public class Solution {

    private static final Solution S = new Solution();

    public String minWindow(String S, String T) {
        int min = S.length();
        int start = 0;
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != T.charAt(j) || ++j < T.length()) {
                continue;
            }

            int end = i + 1;

            while (j > 0) {
                j--;
                while (S.charAt(i--) != T.charAt(j));
            }
            i++;

            if (end - i < min) {
                min = end - i;
                start = i;
            }
        }
        return min == S.length() ? "" : S.substring(start, start + min);
    }

    public static void main(String[] args) {
        System.out.println(S.minWindow("abcdebdde", "bde")); // bcde
        System.out.println(S.minWindow("nkzcnhczmccqouqadqtmjjzltgdzthm", "bt")); // ""
        System.out.println(S.minWindow("abcdebdde", "bde")); // bcde
        System.out.println(S.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l")); // l
        System.out.println(S.minWindow("cnhczmccqouqadqtmjjzl", "mm")); // mccqouqadqtm
        System.out.println(S.minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "kzed")); // kzxwqegknd
    }
}
