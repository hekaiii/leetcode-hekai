package StackAndQueue;

import java.util.*;
import java.util.Map.Entry;

/**
 * 快排 桶排序 大顶堆/小顶堆（优先级队列）
 * PriorityQueue通过注入Comparator的实现类，来表示是大顶堆还是小顶堆
 *
 * PriorityQueue<Map.Entry<Integer, Integer>> heap =
 *     new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
 *
 * Comparator.compare()的实现方法，只需要明白一点：
 *   int compare(T o1, T o2); 返回int
 * 负数：o1 的优先级高，o1 排在 o2 前面。
 * 正数：o2 的优先级高，o2 排在 o1 前面。
 * 零：o1 和 o2 优先级相同，顺序不定。
 * o1>o2返回负数，说明o1的优先级跟小，越小越优，o1排在o2前面，符合小顶堆的规律，小的在前面
 *
 * 还需要熟悉大/小顶堆在poll弹出元素时的顺序问题
 * https://www.cs.usfca.edu/~galles/visualization/Heap.html
 *
 * @Date: 2022/3/23 11:35
 */
public class leetcode_347 {

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
//                System.out.println("Comparator");
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
    //GPT解
    public static int[] topKFrequent01(int[] nums, int k) {
// 1. 统计频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. 使用小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<>(Comparator.comparingInt(Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();  // 保持堆的大小为k
            }
        }

        // 3. 输出结果
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }

    public static int[] topKFrequent02(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (o1, o2) -> o1.getValue()-o2.getValue());
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        int i = k - 1;
        while (heap.size() > 0) {
            Entry<Integer, Integer> poll = heap.poll();
            result[i--] = poll.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] ints = topKFrequent(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3}, 2);
        int[] ints = topKFrequent02(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
