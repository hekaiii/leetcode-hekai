package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/3 0:11
 */
public class leetcode_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i == map.get(target - nums[i])) {
                    continue;
                } else {
                    return new int[]{i,map.get(target - nums[i])};
                }
            }
        }
        return new int[]{};
    }
    //垃圾算法
    public static int[] twoSum01(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int fast = i + 1;
            while (fast < nums.length) {
                if (nums[i] + nums[fast] != target) {
                    fast++;
                } else {
                    result[0] = i;
                    result[1] = fast;
                    return result;
                }
            }
        }
        return result;
    }

    //最优解
    public static int[] twoSum02(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int[] ints = twoSum02(num,9);
        System.out.println(Arrays.toString(ints));
    }
}
