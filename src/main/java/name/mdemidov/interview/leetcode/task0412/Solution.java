package name.mdemidov.interview.leetcode.task0412;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples
 * of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().fizzBuzz(18));
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean mult3 = i % 3 < 1;
            boolean mult5 = i % 5 < 1;
            if (mult3 && mult5) {
                res.add("FizzBuzz");
            } else if (mult3) {
                res.add("Fizz");
            } else if (mult5) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
//        return IntStream.range(1, n + 1).mapToObj(
//            i -> String.format("%s%s%s", i % 3 > 0 && i % 5 > 0 ? i : "",
//                               i % 3 > 0 ? "" : "Fizz",
//                               i % 5 > 0 ? "" : "Buzz")).collect(Collectors.toList());
    }

}
