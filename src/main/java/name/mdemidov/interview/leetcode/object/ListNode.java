package name.mdemidov.interview.leetcode.object;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int... values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("Empty list of values");
        }
        val = values[0];
        next = add(values, 1);
    }

    public ListNode append(ListNode node) {
        ListNode last = this;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        return this;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : "->" + next);
    }

    private ListNode add(int[] values, int startIndex) {
        if (startIndex >= values.length) {
            return null;
        }
        ListNode node = new ListNode(values[startIndex]);
        if (startIndex < values.length - 1) {
            node.next = add(values, startIndex + 1);
        }
        return node;
    }
}
