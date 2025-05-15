package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/14
 */
public class leetcode_122 {
  public static int maxProfit(int[] prices) {
    //用dp思想解题 dp表示当前最大金
    int[][] dp = new int[prices.length][2];
    //[][0] 代表不持股 [][1] 代表持股了
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]); //不持股 可能现在这个价格卖掉了，也可能我之前也没股
      dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i - 1][1]); //持股 现在持股 可能我现在买股了 也可能持续持股
    }
    return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
  }

  public static void main(String[] args) {
    int[] prices = new int[]{7,6,4,3,1};
    System.out.println(maxProfit(prices));

  }
}
