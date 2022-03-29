package StackAndQueue;

import jdk.nashorn.internal.parser.Token;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/22 15:22
 */
public class leetcode_150 {
    public static void main(String[] args) {
        String[] a = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(a));

    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> a = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                a.add(a.pop() + a.pop());
            } else if (tokens[i].equals("-")) {
                int top = a.pop();
                int second = a.pop();
                a.add(second - top);
            } else if (tokens[i].equals("*") ) {
                a.add(a.pop() * a.pop());
            } else if (tokens[i].equals("/")) {
                int top = a.pop();
                int second = a.pop();
                a.add(second / top);
            } else{
                a.add(Integer.parseInt(tokens[i]));
            }
        }
        return a.pop();
    }
}
