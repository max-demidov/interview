package name.mdemidov.interview.leetcode.task0179;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number/
 *
 * 179. Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Solution {

    private static final Solution S = new Solution();

    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(array, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        if (array[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(S.largestNumber(new int[]{10, 2})); // 210
        System.out.println(S.largestNumber(new int[]{3, 30, 34, 5, 9})); // 9534330
        System.out.println(S.largestNumber(new int[]{121, 12})); // 12121
        System.out.println(S.largestNumber(new int[]{0, 0})); // 0
        System.out.println(S.largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398,
                                                     8247})); // 9609938824824769735703560743981399
    }
}
