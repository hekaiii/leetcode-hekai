package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/27
 */
public class leetcode_53 {
  //n
  public static int maxSubArray(int[] nums) {
    //dp[i][j]表示数组nums 从i到j数组组合的最大值
    int[][] dp = new int[nums.length][nums.length];
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      dp[i][i] = nums[i];
      result = Math.max(result, dp[i][i]);
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        dp[i][j] = dp[i][j - 1] + nums[j];
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }

  public static int maxSubArray01(int[] nums) {
    //dp[i] 表示以nums[i]结尾的最大连续子序列的和
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      result = Math.max(result, dp[i]);
    }
    return result;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray01(nums));
  }
}
