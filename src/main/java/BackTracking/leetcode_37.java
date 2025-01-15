package BackTracking;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/15
 */
public class leetcode_37 {
  public void solveSudoku(char[][] board) {
    backtracking(0, 0, board);
  }

  private void backtracking(int row, int column, char[][] board) {
    if (row == 9 && column == 9) {
      return;
    }
    for (int r = row; r <= 9; r++) {
      for (int c = column; c <= 9; c++) {
        if (board[r][c] != '.') {
          continue;
        }
        for (char k = '1'; k <= '9'; k++) {
          if (isValid(r, c, k, board)) {
            board[r][c] = 'k';
            backtracking(board);
            board[r][c] = '.';
          }
        }
      }
    }
  }

  private static boolean isValid(int r, int c, char k, char[][] board) {

  }



    public static void main(String[] args) {

  }
}
