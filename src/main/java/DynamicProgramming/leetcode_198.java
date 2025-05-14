package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/13
 */
public class leetcode_198 {

  public static int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    //dp[i]为考虑下标i（包含i） 最大的金额dp[i]
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[nums.length - 1];
  }
  public static void main(String[] args) {
    int[] nums = new int[]{2, 1, 1, 2};
    System.out.println(rob(nums));
  }
}
