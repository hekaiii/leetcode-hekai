package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/8
 */
public class leetcode_377 {
  public static int combinationSum4(int[] nums, int target) {
    //dp[j]组成j的最大中排列数
    int[] dp = new int[target + 1];
    dp[0] = 1;
    //如果nums=[1,2,3] 那么结果只能是1,1,2不可能是1,2,1
//    for (int i = 0; i < nums.length; i++) {
//      for (int j = nums[i]; j <= target; j++) {
//        dp[j] += dp[j - nums[i]];
//      }
//    }
    for (int j = 1; j <= target; j++) {
      for (int i = 0; i < nums.length; i++) {
        if (j >= nums[i]) {
          dp[j] += dp[j - nums[i]];
        }
      }
    }
    return dp[target];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    int target = 4;
    System.out.println(combinationSum4(nums, target));

  }
}
