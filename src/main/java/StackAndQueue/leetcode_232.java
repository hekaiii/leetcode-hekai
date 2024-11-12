package StackAndQueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/21 12:33
 */

public class leetcode_232 {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        stackmove();
        return stackOut.pop();
    }

    //java里Stack的peek方法是返回栈顶的元素但不移除它。
    public int peek() {
        stackmove();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    public void stackmove() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
