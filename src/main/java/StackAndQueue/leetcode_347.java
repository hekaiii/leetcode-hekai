package StackAndQueue;

import java.util.*;

/**
 * @Date: 2022/3/23 11:35
 */
public class leetcode_347 {
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();//map.entrySet() 获取map中所有entry组成的set
//        PriorityQueue<Map.Entry<Integer, Integer>> queue1 = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                System.out.println("Comparator");
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
