package name.mdemidov.interview.leetcode.task0341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private LinkedList<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = flatten(nestedList);
    }

    private static LinkedList<Integer> flatten(List<NestedInteger> nestedList) {
        LinkedList<Integer> list = new LinkedList<>();
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                list.add(i.getInteger());
            } else {
                list.addAll(flatten(i.getList()));
            }
        }
        return list;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.poll();
    }

}
