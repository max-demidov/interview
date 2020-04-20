package name.mdemidov.interview.leetcode.task0017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations \
 * that the number could represent.
 *
 * A mapping of digit to LETTERS (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any LETTERS.
 *
 * 2 - abc
 * 3 - def
 * 4 - ghi
 * 5 - jkl
 * 6 - mno
 * 7 - pqrs
 * 8 - tuv
 * 9 - wxyz
 */
public class Solution {

    private static final Map<Character, char[]> LETTERS = new HashMap<Character, char[]>() {
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("579"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = Collections.emptyList();
        if (digits.isEmpty()) {
            return res;
        }
        for (char digit : digits.toCharArray()) {
            res = makeCombinations(res, digit);
        }
        return res;
    }

    private List<String> makeCombinations(List<String> combinations, char digit) {
        if (!LETTERS.containsKey(digit)) {
            return combinations;
        }
        List<String> res = new ArrayList<>();
        if (combinations.isEmpty()) {
            for (char c : LETTERS.get(digit)) {
                res.add(String.valueOf(c));
            }
        }
        for (String combination : combinations) {
            for (char c : LETTERS.get(digit)) {
                res.add(String.format("%s%c", combination, c));
            }
        }
        return res;
    }
}
