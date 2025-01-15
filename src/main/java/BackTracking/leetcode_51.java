package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/14
 */
public class leetcode_51 {
  public static List<List<String>> solveNQueens(int n) {
    ArrayList<List<String>> result = new ArrayList<>();
    char[][] chessboard = new char[n][n];
    for (char[] c : chessboard) {
      Arrays.fill(c, '.');
    }
    backTracking(n, chessboard, result, 0);
    return result;
  }

  private static void backTracking(int n, char[][] chessboard, ArrayList<List<String>> result, int row) {
    if (row == n) {
      ArrayList<String> list = new ArrayList<>();
      for (char[] chars : chessboard) {
        list.add(String.valueOf(chars));
      }
      result.add(list);
    }
    for (int i = 0; i < n; i++) {
      if (isValid(row, i, chessboard, n)) {
        chessboard[row][i] = 'Q';
        backTracking(n, chessboard, result, row + 1);
        chessboard[row][i] = '.';
      }
    }
  }

  private static boolean isValid(int row, int column, char[][] chessboard, int n) {
    //检查行
    for (int i = 0; i < row; i++) {
      if (chessboard[i][column] == 'Q') {
        return false;
      }
    }
    for (int i = row - 1, j = column - 1; i >= 0 && j >= 0;
        i--, j--) {
      if (chessboard[i][j] == 'Q') {
        return false;
      }
    }

    for (int i = row - 1, j = column + 1; i >= 0 && j < n;
        i--, j++) {
      if (chessboard[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    List<List<String>> lists = solveNQueens(4);
    for (List<String> list : lists) {
      System.out.println(list.toString());
    }
  }
}
