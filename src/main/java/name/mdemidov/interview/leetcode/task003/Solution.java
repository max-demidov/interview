package name.mdemidov.interview.leetcode.task003;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Solution {

    public static void main(String[] args) {
        String input = "abacabvcbb";
        int output = new Solution().lengthOfLongestSubstring(input);
        System.out.println(output);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int max = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (s.substring(i, j).contains(String.valueOf(chars[j]))) {
                    break;
                }
                max++;
            }
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}
