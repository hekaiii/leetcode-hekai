package Array;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2023/8/17
 */
public class leetcode_59 {

  public static void main(String[] args) {
//    int[][] ints = generateMatrix02(3);
    int[][] ints = generateMatrix03(3,4);
    for (int[] anInt : ints) {
      for (int i : anInt) {
        System.out.print(i+" ");
      }
      System.out.println();
    }
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

  public static int[][] generateMatrix01(int n) {
    int[][] result = new int[n][n];
    int value = 1;
    int top = 0;
    int left = 0;
    int right = n - 1;
    int bottle = n - 1;
    while (value <= n * n) {
      for (int i = left; i <= right; i++) {
        result[top][i] = value++;
      }
      top++;
      for (int i = top; i <= bottle; i++) {
        result[i][right] = value++;
      }
      right--;
      for (int i = right; i >= left; i--) {
        result[bottle][i]=value++;
      }
      bottle--;
      for (int i = bottle; i >=top; i--) {
        result[i][left]=value++;
      }
      left++;
    }
    return result;
  }

  public static int[][] generateMatrix02(int n) {
    int value = 1;
    int top = 0;
    int bottle = n - 1;
    int left = 0;
    int right = n - 1;
    int[][] res = new int[n][n];
    while (value <= n * n) {
      for (int i = left; i <= right; i++) {
        res[top][i]=value++;
      }
      top++;
      for (int i = top; i <= bottle; i++) {
        res[i][right]=value++;
      }
      right--;
      for (int i = right; i >= left; i--) {
        res[bottle][i]=value++;
      }
      bottle--;
      for (int i = bottle; i >= top; i--) {
        res[i][left]=value++;
      }
      left++;
    }
    return res;
  }

  public static int[][] generateMatrix03(int m,int n) {
    int value = 1;
    int top = 0;
    int bottle = m - 1;
    int left = 0;
    int right = n - 1;
    int[][] res = new int[m][n];
    while (value <= m * n) {
      for (int i = left; i <= right; i++) {
        res[top][i]=value++;
      }
      top++;
      for (int i = top; i <= bottle; i++) {
        res[i][right]=value++;
      }
      right--;

      if (bottle >= top) {
        for (int i = right; i >= left; i--) {
          res[bottle][i]=value++;
        }
        bottle--;
      }

      if (right >= left) {
        for (int i = bottle; i >= top; i--) {
          res[i][left] = value++;
        }
        left++;
      }

    }
    return res;
  }
}
