package name.mdemidov.interview.leetcode.task0251;

/**
 * https://leetcode.com/problems/flatten-2d-vector/
 *
 * 251. Flatten 2D Vector
 *
 * Design and implement an iterator to flatten a 2d vector.
 * It should support the following operations: next and hasNext.
 *
 * Example:
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *
 * Notes:
 *
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables
 * are persisted across multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next
 * element in the 2d vector when next() is called.
 *
 * Follow up:
 *
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Vector2D {

    private int[][] v;
    private int y;
    private int x;

    public Vector2D(int[][] v) {
        this.v = v;
        y = 0;
        x = 0;
    }

    public int next() {
        hasNext();
        int res = v[y][x];
        if (x < v[y].length - 1) {
            x++;
        } else {
            x = 0;
            y++;
        }
        return res;
    }

    public boolean hasNext() {
        while (y < v.length && v[y].length < 1) {
            y++;
        }
        return y < v.length && x < v[y].length;
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(new int[][]{{1, 2}, {3}, {4}});
        System.out.println(v1.next()); // return 1
        System.out.println(v1.next()); // return 2
        System.out.println(v1.next()); // return 3
        System.out.println(v1.hasNext()); // return true
        System.out.println(v1.hasNext()); // return true
        System.out.println(v1.next()); // return 4
        System.out.println(v1.hasNext()); // return false

        Vector2D v2 = new Vector2D(new int[][]{{}, {3}});
        System.out.println(v2.hasNext()); // true
        System.out.println(v2.next()); // 3
        System.out.println(v2.hasNext()); // false
    }
}
