package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/8
 */
public class leetcode_322 {

  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp,10001);
    dp[0] = 0;
    for (int j = 1; j <= amount; j++) {
      for (int i = 0; i < coins.length; i++) {
        if (j >= coins[i]) {
          dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
      }
    }
    return dp[amount] == 10001 ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = new int[]{2};
    int amount = 3;
    System.out.println(coinChange(coins, amount));
  }
}
