package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/15
 */
public class leetcode_188 {
  public static int maxProfit(int k, int[] prices) {
    //dp[][]
    int[][] dp = new int[prices.length][2 * k + 1];
    //初始化 没操作
    for (int i = 0; i <= 2 * k; i++) {
      if (i % 2 == 1) {
        dp[0][i] = -prices[0];
      } else {
        dp[0][i] = 0;
      }
    }

    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j <= 2 * k; j++) {
        if (j == 1) {
          dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
        } else if (j % 2 == 0) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
        }
      }
    }
    int result = 0;
    for (int i = 2; i <= 2 * k; i += 2) {
      result = Math.max(result, dp[prices.length - 1][i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] prices = new int[]{3,3,5,0,0,3,1,4};
    System.out.println(maxProfit(2,prices));
  }
}
