package top100;

import java.util.HashMap;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/7/1
 */
public class leeicode_0001 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(target - nums[i])) {
        return new int[]{hashMap.get(target - nums[i]), i};
      }
      hashMap.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
  }
}
