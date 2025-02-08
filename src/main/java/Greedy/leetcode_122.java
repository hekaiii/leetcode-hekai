package Greedy;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-08 20:21:51
 */
public class leetcode_122 {
  public static int maxProfit(int[] prices) {
    int result = 0;
    int buy = 0;
    if (prices.length == 1) {
      return result;
    }
    for (int i = 1; i < prices.length; i++) {
      if ((prices[i] - prices[i - 1] < 0)) {
        buy = i;
      }
      if ((prices[i] - prices[i - 1] > 0)) {
        result += prices[i] - prices[buy];
        buy = i;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[] p = {5,4};
    System.out.println(maxProfit(p));
  }
}
