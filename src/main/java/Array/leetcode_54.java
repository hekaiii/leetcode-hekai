package Array;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2023/8/18
 */
public class leetcode_54 {

  public static void main(String[] args) {
//    int[][] a = new int[3][4];
//    System.out.println(a.length + " " + a[0].length);

    BigDecimal bigDecimal = new BigDecimal(99.99);
    System.out.println(bigDecimal.multiply(new BigDecimal(100)));
  }

//  public static List<Integer> spiralOrder(int[][] matrix) {
//    if (matrix.length == 0) {
//      return new ArrayList<Integer>();
//    }
//    int value = 1;
//    int start = 0;
//    int loop = 1;
//    int rows = matrix.length;
//    int column = matrix[0].length;
//    int max = matrix[0].length * matrix.length;
//    int[][] result = new int[rows][column];
//    ArrayList<Integer> result = new ArrayList<>();
//    while (value <= max) {
//      for (int i = start; i < column - loop; i++) {
//        result.add()
//        result[start][i] =value++;
//      }
//      for (int i = start; i < rows - loop; i++) {
//        result[i][rows-loop] =value++;
//      }
//      for (int i = column-loop; i >start; i--) {
//        result[column-loop][i]=value++;
//      }
//      for (int i = rows-loop; i >start; i--) {
//        result[i][rows-loop] = value++;
//      }
//      start++;
//      loop++;
//
//    }
//    return ;
//  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    return null;
  }
}
