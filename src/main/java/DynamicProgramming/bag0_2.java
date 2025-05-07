package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-21 19:31:27
 */
public class bag0_2 {
  public static int knapsack(int[] weight, int[] value, int bagWeight){
    int[] dp = new int[bagWeight + 1];
    for (int i = 0; i < weight.length; i++) {
      for (int j = bagWeight; j >= weight[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }
    return dp[bagWeight];
  }
  public static void main(String[] args) {
    int[] weight = {3, 1, 4};
    int[] value = {20, 15, 30};
    int bagWeight = 4;
    System.out.println(knapsack(weight, value, bagWeight));
  }
}
