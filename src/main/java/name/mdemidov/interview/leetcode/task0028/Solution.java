package name.mdemidov.interview.leetcode.task0028;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        if (needleChars.length > haystackChars.length) {
            return -1;
        } else if (needleChars.length < 1) {
            return 0;
        }
        for (int i = 0; i < haystackChars.length; i++) {
            boolean isFound = true;
            for (int j = 0; j < needleChars.length; j++) {
                if (i + j >= haystackChars.length || needleChars[j] != haystackChars[i + j]) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return i;
            }
        }
        return -1;
    }
}
