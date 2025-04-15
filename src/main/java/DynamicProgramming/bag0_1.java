package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-15 07:40:20
 */
public class bag0_1 {
  //二维dp
  public static int knapsack(int[] weight, int[] value, int bagWeight) {
    int n = weight.length;
    int[][] dp = new int[n][bagWeight + 1];

    // 初始化：第0个物品能放下的情况
    for (int i = weight[0]; i <= bagWeight; i++) {
      dp[0][i] = value[0];
    }

    // 状态转移
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= bagWeight; j++) {
        if (j < weight[i]) {
          dp[i][j] = dp[i - 1][j]; // 不放第i个物品
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]); // 不放 or 放
        }
      }
    }
    return dp[n - 1][bagWeight];
  }

  //一维dp
  public static int knapsack01(int[] weight, int[] value, int bagWeight) {
    int[] dp = new int[bagWeight + 1];
    dp[0] = 0;
    //商品
    for (int i = 0; i < weight.length; i++) {
      //背包空间 从背包空间大往小倒叙装
//      for (int j = bagWeight; j >= weight[i]; j--) {
//        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//      }
      for (int j = 1; j <= bagWeight; j++) {
        if (j < weight[i]) {
          dp[j] = dp[j - 1];
        } else {
          dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
        }
      }
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    int[] weight = {3, 1, 4};
    int[] value = {20, 15, 30};
    int bagWeight = 4;
    System.out.println(knapsack01(weight, value, bagWeight));
  }
}
