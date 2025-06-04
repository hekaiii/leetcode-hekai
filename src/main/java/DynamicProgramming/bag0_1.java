package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-15 07:40:20
 */
public class bag0_1 {
  //二维dp
  public static int knapsack(int[] weight, int[] value, int bagWeight) {
    //dp[][] = int[物品种类][背包重量]
    int[][] dp = new int[value.length][bagWeight + 1];
    //初始化 [0][j] 第一行
    for (int j = 0; j <= bagWeight; j++) {
      if (j >= weight[0]) {
        dp[0][j] = value[0];
      }
    }
    //先遍历物品
    for (int i = 1; i < value.length; i++) {
      //再遍历背包重量
      for (int j = 1; j <= bagWeight; j++) {
        if (weight[i] > j) {
          dp[i][j] = dp[i-1][j];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
        }
      }
    }
    return dp[value.length - 1][bagWeight];
  }
  //一维dp
  public static int knapsack1(int[] weight, int[] value, int bagWeight) {
    int[] dp = new int[bagWeight + 1];
    //先物品
    for (int i = 0; i < weight.length; i++) {
      //再背包空间
      for (int j = bagWeight; j >=weight[i]; j--) {
        //空间大于当前物品重量时，比较当前结果dp[j]（其实为不存放物品i时的最大价值）和存放当前物品i后的最大价值
          dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }
    return dp[bagWeight];
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
    int[] weight = {4, 3, 1, 4};
    int[] value = {40, 20, 15, 30};
    int bagWeight = 4;
    System.out.println(knapsack1(weight, value, bagWeight));
  }
}
