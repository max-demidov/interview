package name.mdemidov.interview.leetcode.task0946;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 *
 * 946. Validate Stack Sequences
 *
 * Given two sequences pushed and popped with distinct values, return true if and only if this
 * could have been the result of a sequence of push and pop operations on an initially empty stack.
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 * Note:
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean[] gone = new boolean[pushed.length];
        int i = 0;
        int j = 0;
        while (j < popped.length) {
            while (gone[i] || pushed[i] != popped[j]) {
                if (++i >= pushed.length) {
                    return false;
                }
            }
            //System.out.printf("i=%d, j=%d%n", i, j);
            gone[i] = true;
            j++;
            while (i > 0 && gone[i]) {
                i--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed1 = new int[]{1, 2, 3, 4, 5};
        int[] popped1 = new int[]{4, 5, 3, 2, 1};
        System.out.println(S.validateStackSequences(pushed1, popped1)); // true

        int[] pushed2 = new int[]{1, 2, 3, 4, 5};
        int[] popped2 = new int[]{4, 3, 5, 1, 2};
        System.out.println(S.validateStackSequences(pushed2, popped2)); // false

        int[] pushed3 = new int[]{0, 1};
        int[] popped3 = new int[]{0, 1};
        System.out.println(S.validateStackSequences(pushed3, popped3)); // true
    }
}
