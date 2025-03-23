package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedMap;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-23 14:07:19
 */
public class leetcode_435 {
  public static int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 1) {
      return 0;
    }
    Arrays.sort(intervals, (a, b) -> {
      return (a[1] - a[0]) - (b[1] - a[0]);
    });
    int result = 0;
    int broder = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < broder) {
        result++;
      } else {
        broder = intervals[i][1];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] a = new int[][]{{1,100},{11,22},{1,11},{2,12}};
    System.out.println(eraseOverlapIntervals(a));
  }
}
