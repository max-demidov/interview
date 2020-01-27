package name.mdemidov.interview.leetcode.task1057;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/campus-bikes/
 *
 * 1057. Campus Bikes
 *
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker
 * and bike is a 2D coordinate on this grid.
 *
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose
 * the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the
 * bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan
 * distance, we choose the pair with the smallest worker index; if there are multiple ways to do
 * that, we choose the pair with the smallest bike index). We repeat this process until there are
 * no available workers.
 *
 * The Manhattan distance between two points p1 and p2 is
 * Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 *
 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the
 * i-th worker is assigned to.
 *
 * Example 1:
 *
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: [1,0]
 * Explanation:
 * Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1.
 * So the output is [1, 0].
 *
 * Example 2:
 *
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: [0,2,1]
 * Explanation:
 * Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus
 * Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
 *
 * Note:
 *
 * 0 <= workers[i][j], bikes[i][j] < 1000
 * All worker and bike locations are distinct.
 * 1 <= workers.length <= bikes.length <= 1000
 */
public class Solution {

    private static final Solution S = new Solution();

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[][] distances = new int[workers.length][bikes.length];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                distances[i][j] = distance(workers[i], bikes[j]);
            }
        }

        int[] res = new int[workers.length];
        for (int n = 0; n < workers.length; n++) {
            int minDist = Integer.MAX_VALUE;
            int workerIndex = 0;
            int bikeIndex = 0;
            for (int i = 0; i < workers.length; i++) {
                for (int j = 0; j < bikes.length; j++) {
                    if (distances[i][j] < minDist) {
                        minDist = distances[i][j];
                        workerIndex = i;
                        bikeIndex = j;
                    }
                }
            }
            res[workerIndex] = bikeIndex;
            for (int i = 0; i < workers.length; i++) {
                distances[i][bikeIndex] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < bikes.length; j++) {
                distances[workerIndex][j] = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    private static int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public static void main(String[] args) {
        int[][] w1 = {{0, 0}, {2, 1}};
        int[][] b1 = {{1, 2}, {3, 3}};
        System.out.println(Arrays.toString(S.assignBikes(w1, b1))); // [1,0]
        int[][] w2 = {{0, 0}, {1, 1}, {2, 0}};
        int[][] b2 = {{1, 0}, {2, 2}, {2, 1}};
        System.out.println(Arrays.toString(S.assignBikes(w2, b2))); // [0,2,1]
        int[][] w3 = {
            {240, 446}, {745, 948}, {345, 136}, {341, 68}, {990, 165}, {165, 580}, {133, 454},
            {113, 527}
        };
        int[][] b3 = {
            {696, 140}, {95, 393}, {935, 185}, {767, 205}, {387, 767}, {214, 960}, {804, 710},
            {956, 307}
        };
        System.out.println(Arrays.toString(S.assignBikes(w3, b3))); // [7,6,0,3,2,4,1,5]
    }

}
