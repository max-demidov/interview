package name.mdemidov.interview.leetcode.task0528;

import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 *
 * 528. Random Pick with Weight
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 *
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 *
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 *
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array w.pickIndex has no arguments.
 * Arguments are always wrapped with a list, even if there aren't any.
 *
 * Note:
 *
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
public class Solution {

    Random random;
    private int[] w;

    public Solution(int[] w) {
        random = new Random();
        this.w = new int[w.length];
        this.w[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            this.w[i] = this.w[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int r = random.nextInt(w[w.length - 1]);
        return binarySearch(w, r, 0, w.length - 1);
    }

    private static int binarySearch(int[] w, int r, int left, int right) {
        if (r < w[left] || left == right) {
            return left;
        }
        if (right - left < 2) {
            return right;
        }
        int mid = (left + right) / 2;
        return r < w[mid] ? binarySearch(w, r, left, mid) : binarySearch(w, r, mid + 1, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{2, 3, 5});
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
    }
}
