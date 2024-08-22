package Array;

import java.util.Scanner;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/8/23
 */
public class kama44 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int sum = 0;
    int[][] ints = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ints[i][j] = sc.nextInt();
        sum += ints[i][j];
      }
    }

  }

}
