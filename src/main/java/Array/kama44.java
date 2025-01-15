package Array;

import java.util.Scanner;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/8/23
 */
public class kama44 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] ints = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ints[i][j] = sc.nextInt();
      }
    }
    int[][] prefixMax = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m ; j++) {
        prefixMax[i][j] =
            ints[i - 1][j - 1] + prefixMax[i - 1][j] + prefixMax[i][j - 1] - prefixMax[i - 1][j- 1];
      }
    }
    int total = prefixMax[n][m];
    int minDiff = Integer.MAX_VALUE;
    //先横向分割，找出最小差值
    for (int i = 1; i < n; i++) {
      int sumA = prefixMax[i][m];
      int sumB = total - sumA;
      int diff = Math.abs(sumA - sumB);
      minDiff = Math.min(minDiff,diff);
    }
    //再竖向分割，找出最小差值
    for (int j = 1; j < m; j++) {
      int sumA = prefixMax[n][j];
      int sumB = total - sumA;
      int diff = Math.abs(sumA - sumB);
      minDiff = Math.min(minDiff, diff);
    }
    System.out.println(minDiff);
  }

}
