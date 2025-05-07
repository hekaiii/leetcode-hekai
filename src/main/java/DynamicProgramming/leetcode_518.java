package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/7
 */
public class leetcode_518 {
  public static int change(int amount, int[] coins) {
    //完全背包+计算装满背包的次数
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] += dp[j - coins[i]];
      }
    }
    return dp[amount];
  }
  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 5};
    int amout = 5;
    System.out.println(change(amout, coins));
  }
}
