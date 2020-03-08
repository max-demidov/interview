package name.mdemidov.interview.leetcode.task0862;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * 862. Shortest Subarray with Sum at Least K
 *
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 *
 * If there is no non-empty subarray with sum at least K, return -1.
 *
 * Example 1:
 * Input: A = [1], K = 1
 * Output: 1
 *
 * Example 2:
 * Input: A = [1,2], K = 4
 * Output: -1
 *
 * Example 3:
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 *
 * Note:
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class Solution {

    private static final Solution S = new Solution();

    public int shortestSubarray(int[] A, int K) {
        int min = A.length + 1;
        int[] B = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            B[i + 1] = B[i] + A[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < B.length; i++) {
            while (!deque.isEmpty() && B[i] - B[deque.getFirst()] >= K) {
                min = Math.min(min, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && B[i] < B[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        return min <= A.length ? min : -1;
    }

    public static void main(String[] args) {
        System.out.println(S.shortestSubarray(new int[]{1}, 1)); // 1
        System.out.println(S.shortestSubarray(new int[]{1, 2}, 4)); // -1
        System.out.println(S.shortestSubarray(new int[]{2, -1, 2}, 3)); // 3
        System.out.println(S.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140)); // 2
        System.out.println(S.shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167)); // 3
        System.out.println(
            S.shortestSubarray(new int[]{44, -25, 75, -50, -38, -42, -32, -6, -40, -47}, 19)); // 1
        System.out.println(S.shortestSubarray(
            new int[]{58701, 23101, 6562, 60667, 20458, -14545, 74421, 54590, 84780, 63295, 33238,
                      -10143, -35830, -9881, 67268, 90746, 9220, -15611, 23957, 29506, -33103,
                      -14322, 19079, -34950, -38551, 51786, -48668, -17133, 5163, 15122, 5463,
                      74527, 41111, -3281, 73035, -28736, 32910, 17414, 4080, -42435, 66106, 48271,
                      69638, 14500, 37084, -9978, 85748, -43017, 75337, -27963, -34333, -25360,
                      82454, 87290, 87019, 84272, 17540, 60178, 51154, 19646, 54249, -3863, 38665,
                      13101, 59494, 37172, -16950, -30560, -11334, 27620, 73388, 34019, -35695,
                      98999, 79086, -28003, 87339, 2448, 66248, 81817, 73620, 28714, -46807, 51901,
                      -23618, -29498, 35427, 11159, 59803, 95266, 20307, -3756, 67993, -31414,
                      11468, -28307, 45126, 77892, 77226, 79433}, 1677903)); // 48
    }
}
