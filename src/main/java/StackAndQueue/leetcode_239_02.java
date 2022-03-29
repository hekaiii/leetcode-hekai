package StackAndQueue;

import jdk.nashorn.internal.ir.ForNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Date: 2022/3/23 10:51
 */
public class leetcode_239_02 {
    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> res = new LinkedList<>();
        int[] res1 = new int[nums.length - k + 1];
        int idx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!res.isEmpty() && res.peek() < i - k + 1) {
                res.poll();
            }
            while (!res.isEmpty() && nums[res.peekLast()] < nums[i]) {
                res.pollLast();
            }
            res.offer(i);

            if (i >= k-1) {
                res1[idx++] = nums[res.peek()];
            }
        }
        return res1;
    }

}
