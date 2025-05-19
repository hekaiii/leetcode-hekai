package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/19
 */
public class leetcode_714 {

  /**
   * 收手续费 不限次数交易 手上只能有一个订单
   * 有几种状态
   * 三种状态
   * 1.手上没有股票 可能是今天卖了，可能是延续昨天没有股票的状态
   * dp[i][0] = math.max(dp[i-1][1]+prices,dp[i-1][0])
   *
   * 2.手上有一只股票 可能是今天买了 可能是延续昨天手上有一只股票的状态
   * dp[i][1] = math.max(dp[i-1][1],dp[i-1][0]-prices[i])
   *
   * @param prices
   * @param fee
   * @return
   */
  public static int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length][2];
    dp[0][0] = 0;
    //手上有一只股票 只有两个状态
    dp[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[prices.length - 1][0];
  }
  public static void main(String[] args) {
    int[] prices = new int[]{1,3,7,5,10,3};
    System.out.println(maxProfit(prices, 3));
  }
}
