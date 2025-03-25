package Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-24 21:44:55
 */
public class leetcode_738 {

  public static int monotoneIncreasingDigits(int n) {
    char[] lists = String.valueOf(n).toCharArray();
    int flag = lists.length;
    for (int i = lists.length - 1; i > 0; i--) {
      if (lists[i] < lists[i - 1]) {
        lists[i - 1]--;
        flag = i;
      }
    }
    for (int i = flag; i < lists.length; i++) {
      lists[i] = '9';
    }
    return Integer.parseInt(String.copyValueOf(lists));
  }




  public static void main(String[] args) {
    System.out.println(monotoneIncreasingDigits(561970101));
  }
}
