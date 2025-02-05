package Greedy;

import java.util.Arrays;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-05 19:34:11
 */
public class leetcode_455 {

  public static int findContentChildren(int[] g, int[] s) {
    int result = 0;
    if (s.length == 0) {
      return result;
    }
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    int j = 0;
    while (i < s.length && j < g.length) {
      if (s[i] >= g[j]) {
        result++;
        i++;
        j++;
      } else {
        i++;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[] g = {1, 2};
    int[] s = {1, 2,3};
    System.out.println(findContentChildren(g, s));
  }
}
