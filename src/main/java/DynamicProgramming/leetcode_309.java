package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/15
 * 分别用三种四种解答
 */
public class leetcode_309 {
  public static int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][4];
    /**
     * 三个状态
     * dp[i][0] 持有股票 可能是 dp[i-1][0]保持的，也可能是dp[i][2]-prices[i]
     * dp[i][1] 卖股票的当天 明天进入冷冻期 今天结算收益 dp[i][1] = dp[i][0]+prices[i]
     * dp[i][2] 已过冷冻期 已卖完状态 可再次购买也可以保持前一天收益 dp[i-1][1],dp[i-1][3]
     * dp[i][3] 冷冻期买股票的第二天 这一天不能操作 收益=上一天dp[i-1][1]
     */
    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    dp[0][2] = 0;
    dp[0][3] = 0;
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][3] - prices[i]);
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
      dp[i][3] = dp[i - 1][1];
    }
    return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]), dp[prices.length - 1][3]);
//    return Math.max(dp[prices.length - 1][2],dp[prices.length - 1][1]) ;
  }

  /**
   * 一天冷静期
   * 四种
   * dp[i][0] 持有股票的状态 可能是今天刚买 可能是昨天(昨天是冷静期)买了今天持续 也可能是昨天是空仓状态买了股票 满仓
   * dp[i][1] 今天卖 今天卖了 收米
   * dp[i][2] 冷静期不能操作 冷静期
   * dp[i][3] 手里没股票并且过了冷静期的状态 空仓
   * dp：在第i天赚到的最多的钱
   */

  public static int maxProfit01(int[] prices) {
    int[][] dp = new int[prices.length][4];
    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    dp[0][2] = 0;
    dp[0][3] = 0;
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0],
          Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3] - prices[i]));
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = dp[i - 1][1];
      dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
    }
    return Math.max(dp[prices.length - 1][1],
        Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
  }

  //三种
  public static int maxProfit02(int[] prices) {
    return -1;
  }
  public static void main(String[] args) {
    int[] prices = new int[]{1,2,3,0,2};
    System.out.println(maxProfit01(prices));
  }
}
