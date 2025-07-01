package top100;

import java.util.HashSet;

/**
 * @author hekai
 * @date 2025/7/1 19:49
 * @description TODO
 */
public class leetcode_128 {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int finalResult = 0;
        for (int num : set) {
            int result = 1;
            if (!set.contains(num - 1)) {
                int now = num + 1;
                while (set.contains(now)) {
                    now++;
                    result++;
                }
                finalResult = Math.max(finalResult, result);
            }
        }
        return finalResult;
    }
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 1, 4, 2, 3, 200}));
    }
}
