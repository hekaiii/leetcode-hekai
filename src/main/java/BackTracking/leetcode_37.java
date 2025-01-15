package BackTracking;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025/1/15
 */
public class leetcode_37 {
  public void solveSudoku(char[][] board) {
    backtracking(board);
  }

  private boolean backtracking(char[][] board) {
    for (int r = 0; r <= 9; r++) {
      for (int c = 0; c <= 9; c++) {
        if (board[r][c] != '.') {
          continue;
        }
        for (char k = '1'; k <= '9'; k++) {
          if (isValid(r, c, k, board)) {
            board[r][c] = k;
            if (backtracking(board)) {
              return true;
            }
            board[r][c] = '.';
          }
        }
        return false;
      }
    }
    return true;
  }

  private static boolean isValid(int r, int c, char k, char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (board[r][i] == k) {
        return false;
      }
    }
    for (int i = 0; i < 9; i++) {
      if (board[i][c] == k) {
        return false;
      }
    }
    int rowstart = (r / 3) * 3;
    int columnstart = (c / 3) * 3;
    for (int i = rowstart; i < rowstart + 3; i++) {
      for (int j = columnstart; j < columnstart + 3; j++) {
        if (board[i][j] == k) {
          return false;
        }
      }
    }
    return true;
  }



    public static void main(String[] args) {

  }
}
