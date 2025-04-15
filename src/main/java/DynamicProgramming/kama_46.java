package DynamicProgramming;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-14 07:27:47
 */
public class kama_46 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int bagWeight = scanner.nextInt();
    int[] weight = new int[n];
    int[] value = new int[n];
    for (int i = 0; i < n; i++) {
      weight[i] = scanner.nextInt();
    }
    for (int i = 0; i < n; i++) {
      value[i] = scanner.nextInt();
    }
    int[][] dp = new int[n][bagWeight + 1];

    for (int i = weight[0]; i <= bagWeight; i++) {
      dp[0][i] = value[0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= bagWeight; j++) {
        //判断当前背包重量，有没有装第i个物品的空间
        if (j < weight[i]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
        }
      }
    }
    System.out.println(dp[n - 1][bagWeight]);
  }


}
