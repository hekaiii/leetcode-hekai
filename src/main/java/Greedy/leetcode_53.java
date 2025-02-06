package Greedy;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-06 20:32:35
 */
public class leetcode_53 {

  public static int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int result = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count += nums[i];
      if (count > result) {
        result = count;
      }
      if (count < 0) {
        count = 0;
      }
    }
    return result;

  }
  public static void main(String[] args) {

    maxSubArray()
  }
}
