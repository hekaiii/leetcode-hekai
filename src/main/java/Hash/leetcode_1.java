package Hash;

import java.beans.beancontext.BeanContext;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/3 0:11
 */
public class leetcode_1 {
    public static void main(String[] args) {
    }
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
}
