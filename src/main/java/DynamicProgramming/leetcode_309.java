package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/15
 */
public class leetcode_309 {
  public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][3];
    /**
     * 三个状态
     * dp[i][0] 持有股票 可能是 dp[i-1][0]保持的，也可能是dp[i][2]-prices[i]
     * dp[i][1] 卖股票的翻天 明天进入冷冻期 今天结算收益 dp[i][1] = dp[i][0]+prices[i]
     * dp[i][2] 已过冷冻期 已卖完状态 可再次购买也可以保持前一天收益
     */

  }


  public static void main(String[] args) {

  }
}
