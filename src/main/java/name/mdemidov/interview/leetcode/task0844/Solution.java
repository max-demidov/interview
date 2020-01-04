package name.mdemidov.interview.leetcode.task0844;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * 844. Backspace String Compare
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(new Solution().backspaceCompare("ab##", "c#d#")); // true
        System.out.println(new Solution().backspaceCompare("a##c", "#a#c")); // true
        System.out.println(new Solution().backspaceCompare("a#c", "b")); // false
        System.out.println(new Solution().backspaceCompare("bxj##tw", "bxo#j##tw")); // true
        System.out.println(new Solution().backspaceCompare("xywrrmp", "xywrrmu#p")); // true
    }

    private static int next(String s, int index, int del) {
        if (index < 0) {
            return -1;
        }
        if (s.charAt(index) == '#') {
            return next(s, index - 1, del + 1);
        }
        if (del > 0) {
            return next(s, index - 1, del - 1);
        }
        return index;
    }

    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1;
        int t = T.length() - 1;
        while (true) {
            s = next(S, s, 0);
            t = next(T, t, 0);
            if (s < 0 || t < 0) {
                break;
            }
            //System.out.println(String.format("s=%s, t=%s", S.charAt(s), T.charAt(t)));
            if (S.charAt(s) != T.charAt(t)) {
                return false;
            }
            s--;
            t--;
        }
        return s == t;
    }

}
