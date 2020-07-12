package name.mdemidov.interview.leetcode.task0173;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * <p>
 * 173. Binary Search Tree Iterator
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
 * root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Example:
 *
 * <pre>
 *    7
 *  /  \
 * 3   15
 *    /  \
 *   9   20
 * </pre>
 *
 * <pre>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * </pre>
 * <p>
 * Note:
 * <p>
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height
 * of the tree.
 * <p>
 * You may assume that next() call will always be valid, that is, there will be at least a next
 * smallest number in the BST when next() is called.
 */
public class BSTIterator {

  private Set<Integer> set;
  private Iterator<Integer> it;

  public BSTIterator(TreeNode root) {
    set = new TreeSet<>();
    load(root);
    it = set.iterator();
  }

  private void load(TreeNode node) {
    if (node == null) {
      return;
    }
    set.add(node.val);
    load(node.left);
    load(node.right);
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    return it.next();
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return it.hasNext();
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(7);
    t1.left = new TreeNode(3);
    t1.right = new TreeNode(15);
    t1.right.left = new TreeNode(9);
    t1.right.right = new TreeNode(20);

    BSTIterator it1 = new BSTIterator(t1);
    System.out.println(it1.next()); // 3
    System.out.println(it1.next()); // 7
    System.out.println(it1.next()); // 9
    System.out.println(it1.next()); // 15
    System.out.println(it1.hasNext()); // true
    System.out.println(it1.next()); // 20
    System.out.println(it1.hasNext()); // false
  }
}
