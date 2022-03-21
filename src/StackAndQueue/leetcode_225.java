package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/22 0:24
 */
public class leetcode_225 {
    Deque<Integer> deque = new ArrayDeque<>();

    public void push(int x) {
        deque.addLast(x);
    }

    public int pop() {
        return deque.removeLast();
    }

    public int top() {
        return deque.peekLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}


