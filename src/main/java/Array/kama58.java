package Array;

import java.util.Scanner;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/8/22
 */
public class kama58 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] ints = new int[n];
    for (int i = 0; i < n; i++) {
      ints[i] = sc.nextInt();
    }
    int[] dp = new int[n];
    dp[0] = ints[0];
    for (int i = 1; i < n; i++) {
      dp[i] = dp[i - 1] + ints[i];
    }
    int a;
    int b;
    while (sc.hasNextInt()) {
      a = sc.nextInt();
      b = sc.nextInt();
      System.out.println(dp[b]-dp[a]+ints[a]);
    }
  }
}
