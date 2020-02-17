package name.mdemidov.interview.leetcode.task0846;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights/
 *
 * 846. Hand of Straights
 *
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size W,
 * and consists of W consecutive cards.
 *
 * Return true if and only if she can.
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 *
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 * Note:
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W > 0) {
            return false;
        }
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int i : hand) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        while (!count.isEmpty()) {
            int min = count.firstKey();
            for (int i = min; i < min + W; i++) {
                if (!count.containsKey(i)) {
                    return false;
                }
                if (count.get(i) > 1) {
                    count.put(i, count.get(i) - 1);
                } else {
                    count.remove(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(S.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3)); // true
        System.out.println(S.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4)); // false
        System.out.println(S.isNStraightHand(new int[]{5, 1}, 2)); // false
        System.out.println(S.isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2)); // true
    }
}
