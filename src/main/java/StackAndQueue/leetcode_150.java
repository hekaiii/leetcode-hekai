package StackAndQueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/22 15:22
 */
public class leetcode_150 {

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

    public static int evalRPN01(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token == "+") {
                stack.push(stack.pop() + stack.pop());
            } else if ( token == "-") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token == "*") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (token == "/") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] a = new String[]{"2","1","+","3","*"};
        String[] b = new String[]{"4","13","5","/","+"};
        String[] c = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN01(c));
    }
}
