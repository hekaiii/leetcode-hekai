package Array;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2023/8/17
 */
public class leetcode_59 {

  public static void main(String[] args) {
    int[][] ints = generateMatrix(3);
    System.out.println(ints[0]);
  }

  public static int[][] generateMatrix(int n) {
    int value = 1;
    int loop = 0;
    int start = 0;
    int[][] result = new int[n][n];
    while (loop++ < n / 2) {
      for (int i = start; i < n - loop; i++) {
        result[start][i] = value++;
      }
      for (int i = start; i < n - loop; i++) {
        result[i][n - loop] = value++;
      }
      for (int i = n - loop; i > start; i--) {
        result[n - loop][i] = value++;
      }
      for (int i = n - loop; i > start; i--) {
        result[i][start] = value++;
      }
      start++;
    }
    if (n % 2 == 1) {
      result[start][start] = value;
    }
    return result;
  }

//  public static int[][] generateMatrix01(int n) {
//
//  }
}
