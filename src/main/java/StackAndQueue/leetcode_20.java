package StackAndQueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/22 1:16
 */
public class leetcode_20 {

    public static boolean isValid(String s) {
        Stack<Character> a = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                a.add(')');
            } else if (chars[i] == '[') {
                a.add(']');
            } else if (chars[i] == '{') {
                a.add('}');
            } else if (chars[i] != a.peek()||a.isEmpty()) {
                return false;
            } else {
                a.pop();
            }
        }
        return a.isEmpty();
    }

    public static boolean isValid01(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String a = "{]]]]]}]]";
        String b = "{[()]}";
        System.out.println(isValid01(b));
    }
}
