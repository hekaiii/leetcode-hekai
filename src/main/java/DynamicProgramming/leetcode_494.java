package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/4/28
 */
public class leetcode_494 {
  public static int findTargetSumWays(int[] nums, int target) {
    int sum = Arrays.stream(nums).sum();
    if ((sum + target) % 2 == 1) {
      return 0;
    }
    if (sum < Math.abs(target)) {
      return 0;
    }
    int posNum = (sum + target) / 2;
    int[] dp = new int[posNum + 1];
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = posNum; j >= nums[i]; j--) {
        dp[j] += dp[j - nums[i]];
      }
    }
    return dp[posNum];
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,1,1};
    System.out.println(findTargetSumWays(nums, 3));
  }
}
