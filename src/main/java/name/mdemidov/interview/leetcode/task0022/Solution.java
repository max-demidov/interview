package name.mdemidov.interview.leetcode.task0022;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * Source: https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(8));
    }

    private static String getCombination(int number, int length) {
        String binary = Integer.toBinaryString(number);
        String format = String.format("%s1$%ds", "%", length * 2);
        return String.format(format, binary)
            .replace(' ', '(')
            .replace('0', '(')
            .replace('1', ')');
    }

    private static boolean isValid(String parentheses) {
        int sum = 0;
        for (char c : parentheses.toCharArray()) {
            if (c == '(') {
                sum++;
            } else {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        for (int i = 1; i < Math.pow(4, n); i += 2) {
            String combination = getCombination(i, n);
            if (isValid(combination)) {
                combinations.add(combination);
            }
        }
        return combinations;
    }
}
