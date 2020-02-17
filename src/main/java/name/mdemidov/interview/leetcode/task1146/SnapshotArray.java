package name.mdemidov.interview.leetcode.task1146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array/
 *
 * 1146. Snapshot Array
 *
 * Implement a SnapshotArray that supports the following interface:
 *
 * SnapshotArray(int length) initializes an array-like data structure with the given length.
 * Initially, each element equals 0.
 *
 * void set(index, val) sets the element at the given index to be equal to val.
 *
 * int snap() takes a snapshot of the array and returns the snap_id:
 * the total number of times we called snap() minus 1.
 *
 * int get(index, snap_id) returns the value at the given index,
 * at the time we took the snapshot with the given snap_id
 *
 *
 * Example 1:
 *
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation:
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 *
 * Constraints:
 *
 * 1 <= length <= 50000
 * At most 50000 calls will be made to set, snap, and get.
 * 0 <= index < length
 * 0 <= snap_id < (the total number of times we call snap())
 * 0 <= val <= 10^9
 */
public class SnapshotArray {

    private int snap;
    private List<Map<Integer, Integer>> snapshots;

    public SnapshotArray(int length) {
        snap = 0;
        snapshots = new ArrayList<>();
        snapshots.add(new HashMap<>(length));
    }

    public void set(int index, int val) {
        snapshots.get(snap).put(index, val);
    }

    public int snap() {
        Map<Integer, Integer> prev = snapshots.get(snap);
        snapshots.add(new HashMap<>(prev));
        snap++;
        return snap - 1;
    }

    public int get(int index, int snap_id) {
        return snapshots.get(snap_id).getOrDefault(index, 0);
    }

    public static void main(String[] args) {
        SnapshotArray s1 = new SnapshotArray(3); // set the length to be 3
        s1.set(0, 5);  // Set array[0] = 5
        s1.snap();  // Take a snapshot, return snap_id = 0
        s1.set(0, 6);
        System.out.println(s1.get(0, 0));  // Get the value of array[0] with snap_id = 0, return 5
    }
}
