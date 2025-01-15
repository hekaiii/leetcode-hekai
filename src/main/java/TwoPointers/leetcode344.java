package TwoPointers;

import java.util.Arrays;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/5
 */
public class leetcode344 {

  public static void reverseString(char[] s) {
    if (s.length != 1) {
      int mid = s.length / 2;
      for (int i = 0; i < mid; i++) {
        char tmp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = tmp;
      }
    }
  }

  public static void main(String[] args) {
    char[] chars = {'a', 'b', 'c','d'};
    reverseString(chars);
    System.out.println(Arrays.toString(chars));
  }
}
