package name.mdemidov.interview.leetcode.task0384;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 *
 * 384. Shuffle an Array
 *
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(nums, nums.length);
        for (int i = shuffle.length - 1; i >= 0; i--) {
            int r = random.nextInt(i + 1);
            int swap = shuffle[r];
            shuffle[r] = shuffle[i];
            shuffle[i] = swap;
        }
        return shuffle;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(s1.shuffle()));
        System.out.println(Arrays.toString(s1.reset()));
        System.out.println(Arrays.toString(s1.shuffle()));

        Solution s2 = new Solution(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(s2.shuffle()));
        System.out.println(Arrays.toString(s2.reset()));
        System.out.println(Arrays.toString(s2.shuffle()));
    }
}
