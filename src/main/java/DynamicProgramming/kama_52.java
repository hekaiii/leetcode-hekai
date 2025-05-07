package DynamicProgramming;

/**
 * @Author: hek32
 * @Description: 完全背包问题
 * @Date: 2025/5/7
 */
public class kama_52 {

  //一维dp解题
  public static int knapsack(int[] weight, int[] value, int bagWeight) {
    int[] dp = new int[bagWeight + 1];
    dp[0] = 0;
    for (int i = 0; i < weight.length; i++) {
//      for (int j = 1; j <= bagWeight; j++) {
//        if (j >= weight[i]) {
//          dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//        }
//      }
      for (int j = weight[i]; j <= bagWeight; j++) {
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }
    return dp[bagWeight];
  }
  public static void main(String[] args) {
    int[] weight = new int[]{1, 3, 4};
    int[] value = new int[]{15, 20, 30};
    System.out.println(knapsack(weight, value, 4));
  }
}
