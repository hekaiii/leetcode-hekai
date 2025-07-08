package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/7/2
 */
public class leetcode_0015 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    if (nums[0] > 0) {
      return null;
    }
    ArrayList<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {

    }
    return result;
  }

  public static void main(String[] args) {

  }
}
