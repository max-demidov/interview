package name.mdemidov.interview.leetcode.task0020;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Solution {

    private static final String REGEX = "\\(\\)|\\[]|\\{}";

    private static String cut(String s) {
        String newS = s.replaceAll(REGEX, "");
        if (newS.isEmpty() || newS.equals(s)) {
            return newS;
        }
        return cut(newS);
    }

    public boolean isValid(String s) {
        return cut(s).isEmpty();
    }
}
