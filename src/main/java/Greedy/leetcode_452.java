package Greedy;

import com.sun.corba.se.internal.Interceptors.PIORB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.swing.ImageIcon;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-22 22:22:08
 */
public class leetcode_452 {
  //左对齐
  public static int findMinArrowShots(int[][] points) {
    if (points.length == 1) {
      return 1;
    }
    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
    int start = points[0][0];
    int end = points[0][1];
    int result = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > end) {
        start = points[i][0];
        end = points[i][1];
        result++;
      } else {
        start = Math.max(start, points[i][0]);
        end = Math.min(end, points[i][1]);
      }
    }
    return result;
  }

  //右对齐
  public static int findMinArrowShots01(int[][] points) {
    if (points.length == 1) {
      return 1;
    }
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
    int result = 1;
    int border = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > border) {
        result++;
        border = points[i][1];
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[][] a = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
    System.out.println(findMinArrowShots(a));
  }
}
