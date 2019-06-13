package name.mdemidov.interview.leetcode.task008;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement atoi which converts a string to an integer.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi(".1"));
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String s = str.trim().split(" ")[0];
        Matcher m = Pattern.compile("(^[-+]?[0-9]+)").matcher(s);
        if (!m.find()) {
            return 0;
        }
        s = m.group();
        double res = Double.parseDouble(s);
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
