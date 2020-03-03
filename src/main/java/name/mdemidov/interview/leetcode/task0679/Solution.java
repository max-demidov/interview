package name.mdemidov.interview.leetcode.task0679;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/24-game/
 *
 * 679. 24 Game
 *
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could
 * operated through *, /, +, -, (, ) to get the value of 24.
 *
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 *
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 *
 * Note:
 * The division operator / represents real division, not integer division.
 * For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator.
 * For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2],
 * we cannot write this as 12 + 12.
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean judgePoint24(int[] nums) {
        Double a = (double) nums[0];
        Double b = (double) nums[1];
        Double c = (double) nums[2];
        Double d = (double) nums[3];
        Set<Double> ab = results(a, b);
        Set<Double> ac = results(a, c);
        Set<Double> ad = results(a, d);
        Set<Double> bc = results(b, c);
        Set<Double> bd = results(b, d);
        Set<Double> cd = results(c, d);
        Set<Double> a_bc = new HashSet<>();
        Set<Double> a_bd = new HashSet<>();
        Set<Double> a_cd = new HashSet<>();
        Set<Double> b_ac = new HashSet<>();
        Set<Double> b_ad = new HashSet<>();
        Set<Double> b_cd = new HashSet<>();
        Set<Double> c_ab = new HashSet<>();
        Set<Double> c_ad = new HashSet<>();
        Set<Double> c_bd = new HashSet<>();
        Set<Double> d_ab = new HashSet<>();
        Set<Double> d_ac = new HashSet<>();
        Set<Double> d_bc = new HashSet<>();
        Set<Double> res = new HashSet<>();

        for (Double i : bc) {
            a_bc.addAll(results(a, i));
        }
        for (Double i : bd) {
            a_bd.addAll(results(a, i));
        }
        for (Double i : cd) {
            a_cd.addAll(results(a, i));
        }
        for (Double i : ac) {
            b_ac.addAll(results(b, i));
        }
        for (Double i : ad) {
            b_ad.addAll(results(b, i));
        }
        for (Double i : cd) {
            b_cd.addAll(results(b, i));
        }
        for (Double i : ab) {
            c_ab.addAll(results(c, i));
        }
        for (Double i : ad) {
            c_ad.addAll(results(c, i));
        }
        for (Double i : bd) {
            c_bd.addAll(results(c, i));
        }
        for (Double i : ab) {
            d_ab.addAll(results(d, i));
        }
        for (Double i : ac) {
            d_ac.addAll(results(d, i));
        }
        for (Double i : bc) {
            d_bc.addAll(results(d, i));
        }
        a_bc.forEach(i -> res.addAll(results(i, d)));
        a_bd.forEach(i -> res.addAll(results(i, c)));
        a_cd.forEach(i -> res.addAll(results(i, b)));
        b_ac.forEach(i -> res.addAll(results(i, d)));
        b_ad.forEach(i -> res.addAll(results(i, c)));
        b_cd.forEach(i -> res.addAll(results(i, a)));
        c_ab.forEach(i -> res.addAll(results(i, d)));
        c_ad.forEach(i -> res.addAll(results(i, b)));
        c_bd.forEach(i -> res.addAll(results(i, a)));
        d_ab.forEach(i -> res.addAll(results(i, c)));
        d_ac.forEach(i -> res.addAll(results(i, b)));
        d_bc.forEach(i -> res.addAll(results(i, a)));

        for (Double i : ab) {
            for (Double j : cd) {
                res.addAll(results(i, j));
            }
        }
        for (Double i : ac) {
            for (Double j : bd) {
                res.addAll(results(i, j));
            }
        }
        for (Double i : ad) {
            for (Double j : bc) {
                res.addAll(results(i, j));
            }
        }
        //System.out.println(new TreeSet<>(res));
        return res.stream().anyMatch(r -> 23.999 < r && r < 24.001);
    }

    private static Set<Double> results(Double a, Double b) {
        Set<Double> results = new HashSet<>(6);
        results.add(a + b);
        results.add(a * b);
        results.add(a - b);
        results.add(b - a);
        if (b != 0) {
            results.add(a / b);
        }
        if (a != 0) {
            results.add(b / a);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(S.judgePoint24(new int[]{4, 1, 8, 7})); // true
        System.out.println(S.judgePoint24(new int[]{1, 2, 1, 2})); // false
        System.out.println(S.judgePoint24(new int[]{1, 3, 4, 6})); // true
        System.out.println(S.judgePoint24(new int[]{3, 3, 8, 8})); // true
    }
}
