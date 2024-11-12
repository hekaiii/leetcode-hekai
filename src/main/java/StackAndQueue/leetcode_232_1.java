package StackAndQueue;

import java.util.Stack;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/11/11
 */
public class leetcode_232_1 {

  Stack<Integer> stackIn;
  Stack<Integer> stackOut;

  public void push(int x) {
    stackIn.push(x);
  }

  public int pop() {
    transform();
    return stackOut.pop();
  }

  public int peek() {
    transform();
    return stackOut.peek();
  }

  public boolean empty() {
    return stackIn.isEmpty() && stackOut.empty();
  }

  public void transform() {
    if (!stackOut.isEmpty()) {
      return;
    }
    while (!stackIn.isEmpty()) {
      stackOut.push(stackIn.pop());
    }
  }

  public static void main(String[] args) {

  }
}
