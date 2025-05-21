package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/20
 */
public class leetcode_674 {
  public static int findLengthOfLCIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        dp[i] = dp[i - 1] + 1;
        result = Math.max(dp[i], result);
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 5, 4, 7};
    System.out.println(findLengthOfLCIS(nums));
  }
}
