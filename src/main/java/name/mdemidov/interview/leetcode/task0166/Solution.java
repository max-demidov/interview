package name.mdemidov.interview.leetcode.task0166;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * 166. Fraction to Recurring Decimal
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 *
 * Example 2:
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 *
 * Example 3:
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class Solution {

    private static final Solution S = new Solution();

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) {
            sb.append("-");
        }

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        sb.append(n / d);
        n %= d;
        if (n == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(n, sb.length());

        while (n != 0) {
            n *= 10;
            sb.append(n / d);
            n %= d;
            if (map.containsKey(n)) {
                sb.insert(map.get(n), "(");
                sb.append(")");
                break;
            }
            map.put(n, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(S.fractionToDecimal(1, 2)); // 0.5
        System.out.println(S.fractionToDecimal(2, -1)); // -2
        System.out.println(S.fractionToDecimal(2, 3)); // 0.(6)
        System.out.println(S.fractionToDecimal(4, 333)); // 0.(012)
    }
}
