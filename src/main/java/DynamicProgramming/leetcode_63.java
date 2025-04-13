package DynamicProgramming;

import java.util.function.IntPredicate;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-11 08:20:02
 */
public class leetcode_63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      if (obstacleGrid[i][0] == 1) {
        result[i][0] = 0;
        break;
      } else {
        result[i][0] = 1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (obstacleGrid[0][i] == 1) {
        result[0][i] = 0;
        break;
      } else {
        result[0][i] = 1;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          result[i][j] = 0;
        } else {
          result[i][j] = result[i][j - 1] + result[i - 1][j];
        }
      }
    }
    return result[m - 1][n - 1];
  }
  public static void main(String[] args) {

  }
}
