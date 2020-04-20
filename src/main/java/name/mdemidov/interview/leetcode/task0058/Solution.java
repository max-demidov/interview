package name.mdemidov.interview.leetcode.task0058;

public class Solution {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(new Solution().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        if (!s.contains(" ")) {
            return s.length();
        }
        return s.length() - s.lastIndexOf(' ') - 1;
    }

}
