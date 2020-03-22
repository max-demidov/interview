package name.mdemidov.interview.leetcode.task0380;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public class RandomizedSet {

    private Set<Integer> set;
    private Random r;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
        r = new Random();
    }

    /**
     * Inserts a value to the set.
     * Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return (int) set.toArray()[r.nextInt(set.size())];
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1)); // true
        System.out.println(rs.remove(2)); // false
        System.out.println(rs.insert(2)); // true
        System.out.println(rs.getRandom()); // 1 or 2
        System.out.println(rs.remove(1)); // true
        System.out.println(rs.insert(2)); // false
        System.out.println(rs.getRandom()); // 2
    }
}
