package name.mdemidov.interview.leetcode.task155;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MinStack {

    /**
     * initialize your data structure here.
     */

    private List<Integer> list = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    public MinStack() {

    }

    public static void main(String[] args) {
        MinStack input = new MinStack();
        input.push(512);
        input.push(-1024);
        input.push(-1024);
        input.pop();
        System.out.println(input.getMin());
        input.pop();
        //System.out.println(input.top()); // 0
        System.out.println(input.getMin()); // -2
        input.pop();
        System.out.println(input.getMin());
    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
        Collections.sort(list);
    }

    public void pop() {
        list.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.isEmpty() ? 0 : list.get(0);
    }
}
