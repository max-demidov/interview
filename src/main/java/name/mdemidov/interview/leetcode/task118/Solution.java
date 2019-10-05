package name.mdemidov.interview.leetcode.task118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> output = new ArrayList<>(numRows);
        output.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> prev = output.get(i - 1);
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            output.add(row);
        }
        return output;
    }

}
