package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-17 21:06:05
 */
public class leetcode_860 {
  public static boolean lemonadeChange(int[] bills) {
    if (bills[0] != 5) {
      return false;
    }
    int[] money = new int[2];
    Arrays.fill(money, 0);
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        money[0] = money[0] + 1;
      } else if (bills[i] == 10) {
        if (money[0] >= 1) {
          money[0] = money[0] - 1;
          money[1] = money[1] + 1;
        }
      } else if (bills[i] == 20) {
        if ((money[0] >= 1) && money[1] >= 1) {
          money[0] = money[0] - 1;
          money[1] = money[1] - 1;
        }else if (money[0] >= 3) {
          money[0] = money[0] - 3;
        }else {
          return false;
        }
      }
    }
    return true;
  }
  public static void main(String[] args) {
    int[] a = {5,5,10,10,20};
    System.out.println(lemonadeChange(a));
  }
}
