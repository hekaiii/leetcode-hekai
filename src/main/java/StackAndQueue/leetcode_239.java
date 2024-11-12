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
    public static int[] maxSlidingWindow01(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
    public static int[] maxSlidingWindow02(int[] nums, int k) {
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
    public static int[] maxSlidingWindow03(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> pool = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (pool.size() != 0 && pool.peekFirst() < i - k + 1) {
                pool.pollFirst();
            }
            while (!pool.isEmpty() && nums[pool.peekLast()] < nums[i]) {
                pool.pollLast();
            }
            pool.addLast(i);
            if (i >= k - 1) {
                result[i-k+1] = nums[pool.peekFirst()] ;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] b = {7,2,4};
        int[] c = {1,3,1,2,0,5};
        int[] ints = maxSlidingWindow03(c, 3);
        System.out.println(Arrays.toString(ints));
    }
}
