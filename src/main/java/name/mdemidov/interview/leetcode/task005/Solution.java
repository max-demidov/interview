package name.mdemidov.interview.leetcode.task005;

public class Solution {

    public static void main(String[] args) {
        String input = "cbbdbbc";
        String output = new Solution().longestPalindrome(input);
        System.out.println(output);
    }

    public static String longestPalindrome(String s, int index) {
        int start = index;
        int end = index;
        while (end + 1 < s.length() && s.charAt(index) == s.charAt(end + 1)) {
            end++;
        }
        while (start > 0 && end < s.length() - 1) {
            if (s.charAt(start - 1) != s.charAt(end + 1)) {
                break;
            }
            start--;
            end++;
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String local = longestPalindrome(s, i);
            System.out.println(i + local);
            if (local.length() > longest.length()) {
                longest = local;
            }
        }
        return longest;
    }
}
