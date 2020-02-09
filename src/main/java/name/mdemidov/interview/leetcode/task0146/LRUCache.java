package name.mdemidov.interview.leetcode.task0146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new
 * item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(2);
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    private int cap;
    private Queue<Integer> queue;
    private Map<Integer, Integer> values;

    public LRUCache(int capacity) {
        cap = capacity;
        queue = new LinkedList<>();
        values = new HashMap<>();
    }

    public int get(int key) {
        if (!queue.contains(key) || values.get(key) == null) {
            return -1;
        }
        refreshQueue(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        refreshQueue(key);
        values.put(key, value);
    }

    private void refreshQueue(int key) {
        queue.removeIf(k -> k == key);
        while (queue.size() >= cap) {
            values.remove(queue.poll());
        }
        queue.offer(key);
    }

    public static void main(String[] args) {
        LRUCache c1 = new LRUCache(2);
        c1.put(1, 1);
        c1.put(2, 2);
        System.out.println(c1.get(1)); // 1
        c1.put(3, 3);
        System.out.println(c1.get(2)); // -1
        c1.put(4, 4);
        System.out.println(c1.get(1)); // -1
        System.out.println(c1.get(3)); // 3
        System.out.println(c1.get(4)); // 4
        System.out.println();

        LRUCache c2 = new LRUCache(2);
        System.out.println(c2.get(2)); // -1
        c2.put(2, 6);
        System.out.println(c2.get(1)); // -1
        c2.put(1, 5);
        c2.put(1, 2);
        System.out.println(c2.get(1)); // 2
        System.out.println(c2.get(2)); // 6

    }
}
