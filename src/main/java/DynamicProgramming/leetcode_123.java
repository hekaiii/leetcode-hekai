package DynamicProgramming;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/14
 */
public class leetcode_123 {
  public static int maxProfit(int[] prices) {
    //dp[][]
    int[][] dp = new int[prices.length][5];
    //初始化 没操作
    dp[0][0] = 0;
    //买了第一次
    dp[0][1] = -prices[0];
    //卖了第一次
    dp[0][2] = 0;
    //买了第二次
    dp[0][3] = -prices[0];
    //卖了第二次
    dp[0][4] = 0;

    for (int i = 1; i < prices.length; i++) {
      //还是没操作
      dp[i][0] = 0;
      //i的时候 处于持有第一手股票中 可能继续持有，可能买了
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
      //i的时候 处于抛出第一手股票中，可能i的时候刚卖，可能i之前就卖了此时没做操作
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
      //i的时候 处于持有第二手股票的时候 可能刚买 可能继续持有
      dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
      //i的时候 处于抛出第二手股票 可能在i的时候刚卖 可能i之前就卖了 现在不做操作
      dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
    }
    return Math.max(dp[prices.length - 1][2], dp[prices.length - 1][4]);
  }

  public static void main(String[] args) {
    int[] prices = new int[]{3,3,5,0,0,3,1,4};
    System.out.println(maxProfit(prices));
  }

}
