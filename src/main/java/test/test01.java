package test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/22 0:39
 */
public class test01 {
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a.pollLast());
        System.out.println(a.pollLast());

        Stack<Integer> b = new Stack<>();
        b.add(1);
        b.add(2);
        b.add(3);
        System.out.println(b.pop());
        System.out.println(b.pop());
    }
}
