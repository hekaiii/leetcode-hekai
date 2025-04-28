package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/4/27
 */
public class leetcode_1049 {

  /**
   * 动规5部曲
   * 1.DP数组的含义
   * 2.dp推导公式
   * 3.初始化
   * 4.方向
   * 5.打印
   * @param stones
   * @return
   */
  public static int lastStoneWeightII(int[] stones) {
    if (stones.length == 1) {
      return 0;
    }
    int sum = Arrays.stream(stones).sum();
    int target = sum / 2;
    int[] dp = new int[target + 1];
    dp[0] = 0;
    for (int i = 0; i < stones.length; i++) {
      for (int j = target; j >= stones[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
      }
    }
    return sum - 2 * dp[target];
  }

  public static void main(String[] args) {
    int[] stones = {31,26,33,21,40};
    System.out.println(lastStoneWeightII(stones));
  }
}
