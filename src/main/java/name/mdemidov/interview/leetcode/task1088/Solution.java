package name.mdemidov.interview.leetcode.task1088;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/confusing-number-ii/
 *
 * 1088. Confusing Number II
 *
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180
 * degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees,
 * they become invalid.
 *
 * A confusing number is a number that when rotated 180 degrees becomes a different number with
 * each digit valid.(Note that the rotated number can be greater than the original number.)
 *
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 *
 * Example 1:
 *
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 *
 * Example 2:
 *
 * Input: 100
 * Output: 19
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 *
 * Note:
 *
 * 1 <= N <= 10^9
 */
public class Solution {

    private static final Solution S = new Solution();

    private static final int[] T = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    private static final int[] D = {0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        int res = 0;
        int n = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (n < N) {
            int i = queue.poll();
            for (int d : D) {
                n = i * 10 + d;
                if (n == 0) {
                    continue;
                }
                if (n > N) {
                    return res;
                }
                if (confusing(n)) {
                    res++;
                }
                queue.offer(n);
            }
        }

        return res;
    }

    private static boolean confusing(int n) {
        int r = 0;
        int tmp = n;
        while (tmp > 0) {
            r = 10 * r + T[tmp % 10];
            tmp /= 10;
        }
        return r != n;
    }

    public static void main(String[] args) {
        System.out.println(S.confusingNumberII(0)); // 0
        System.out.println(S.confusingNumberII(20)); // 6
        System.out.println(S.confusingNumberII(100)); // 19
        System.out.println(S.confusingNumberII(90)); // 15
        System.out.println(S.confusingNumberII(195)); // 37
        System.out.println(S.confusingNumberII(9)); // 2
        System.out.println(S.confusingNumberII(99)); // 18
        System.out.println(S.confusingNumberII(999)); // 106
        System.out.println(S.confusingNumberII(9999)); // 586
        System.out.println(S.confusingNumberII(99999)); // 3026
        System.out.println(S.confusingNumberII(999999)); // 15426
    }
}
