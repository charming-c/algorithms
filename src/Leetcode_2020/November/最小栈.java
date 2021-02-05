package Leetcode_2020.November;

//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
//
//
//        示例：
//
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.


import java.util.Stack;

public class 最小栈 {
    private Stack<StackNode> stack = new Stack<>();

    //压栈
    public void push(int x) {
        if (empty()) {
            stack.push(new StackNode(x, x));
        } else {
            stack.push(new StackNode(x, Math.min(x, getMin())));
        }
    }

    //出栈
    public void pop() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        stack.pop();
    }

    public int top() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        return stack.peek().val;
    }

    public int getMin() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        return stack.peek().min;
    }

    //判断栈是否为空
    private boolean empty() {
        return stack.isEmpty();
    }
}

class StackNode {
    public int val;
    public int min;

    public StackNode(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
