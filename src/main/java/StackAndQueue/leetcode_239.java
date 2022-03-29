package StackAndQueue;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/22 16:03
 *
 *
 * 超出内存限制
 */
public class leetcode_239 {
    public static void main(String[] args) {
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> res = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();
        int[] ints = new int[nums.length - k + 1];
        int i = 0;
        while (i < nums.length) {
            res.addLast(nums[i]);
            if (i == k - 1) {
                int max = -10000;
                for (Integer re : res) {
                    max = max < re ? re : max;
                }
                result.add(max);
            }
            if (i > k - 1) {
                res.removeFirst();
                int max = -10000;
                for (Integer re : res) {
                    max = max < re ? re : max;
                }
                result.add(max);
            }
            i++;
        }
        for (int j = 0; j < ints.length; j++) {
            ints[j] = result.get(j);
        }
        return ints;
    }
}
