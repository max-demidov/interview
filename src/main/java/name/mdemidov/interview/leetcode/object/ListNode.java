package name.mdemidov.interview.leetcode.object;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int... values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("Empty list of values");
        }
        val = values[0];
        next = append(values, 1);
    }

    @Override
    public String toString() {
        return "ListNode{" +
               "val=" + val +
               (next == null ? "" : ", next=" + next) +
               '}';
    }

    private ListNode append(int[] values, int startIndex) {
        if (startIndex >= values.length) {
            return null;
        }
        ListNode node = new ListNode(values[startIndex]);
        if (startIndex < values.length - 1) {
            node.next = append(values, startIndex + 1);
        }
        return node;
    }
}
