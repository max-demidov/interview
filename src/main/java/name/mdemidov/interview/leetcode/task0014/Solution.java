package name.mdemidov.interview.leetcode.task0014;

public class Solution {

    public static void main(String[] args) {
        String[] strs = {"b", "a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        for (int i = 1; i <= strs[0].length(); i++) {
            String substr = strs[0].length() > 1 ? strs[0].substring(0, i) : strs[0];
            for (String s : strs) {
                if (!s.startsWith(substr)) {
                    return i > 1 ? strs[0].substring(0, i - 1) : "";
                }
            }
        }
        return strs[0];
    }

}
