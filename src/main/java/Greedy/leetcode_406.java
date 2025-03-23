package Greedy;

import java.lang.management.LockInfo;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Popup;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-17 21:36:08
 */
public class leetcode_406 {
  public static int[][] reconstructQueue(int[][] people) {
    if (people.length == 1) {
      return people;
    }
    Arrays.sort(people, (a, b) -> {
      if (a[0] != b[0]) {
        return b[0] - a[0];//按第一个元素来降序
      }
      return a[1] - b[1];//按第二个元素来升序
    });
    List<int[]> list = new LinkedList<>();
    for (int[] person : people) {
      list.add(person[1], person);
    }

    return list.toArray(new int[people.length][]);
  }

  public static void main(String[] args) {
    int[][] a = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
    int[][] ints = reconstructQueue(a);
    for (int[] b : ints) {
      System.out.println(b[1]);
    }
  }
}
