package name.mdemidov.interview.leetcode.task0299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * 299. Bulls and Cows
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and
 * ask your friend to guess what the number is. Each time your friend makes a guess, you provide a
 * hint that indicates how many digits in said guess match your secret number exactly in both digit
 * and position (called "bulls") and how many digits match the secret number but locate in the
 * wrong position (called "cows"). Your friend will use successive guesses and hints to eventually
 * derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to
 * indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 *
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 *
 * Note: You may assume that the secret number and your friend's guess only contain digits,
 * and their lengths are always equal.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810")); // 1A3B
        System.out.println(new Solution().getHint("1123", "0111")); // 1A1B
    }

    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        List<Character> rest = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            char g = guess.charAt(i);
            if (guess.charAt(i) == c) {
                a++;
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
                rest.add(g);
            }
        }
        for (char c : rest) {
            if (map.getOrDefault(c, 0) > 0) {
                b++;
                map.put(c, map.getOrDefault(c, 1) - 1);
            }
        }
        return String.format("%dA%dB", a, b);
    }
}
