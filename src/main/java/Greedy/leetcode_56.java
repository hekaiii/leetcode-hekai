package Greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.print.DocFlavor.READER;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-24 20:41:41
 */
public class leetcode_56 {
  public static int[][] merge(int[][] intervals) {
    if (intervals.length == 1) {
      return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> result = new ArrayList<>();

    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > end) {
        result.add(new int[]{start, end});
        start = intervals[i][0];
        end = intervals[i][1];
      } else {
        end = Math.max(end, intervals[i][1]);
      }
      if (i == intervals.length - 1) {
        result.add(new int[]{start, end});
      }
    }
    int[][] aa = new int[result.size()][];
    for (int i = 0; i < result.size(); i++) {
      aa[i] = result.get(i);
    }
    return aa;
  }

  public static void main(String[] args) {
    int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] merge = merge(a);
    for (int[] ints : merge) {
      System.out.println(Arrays.toString(ints));
    }
  }
}
