package Greedy;

import com.sun.corba.se.impl.oa.toa.TOA;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-13 20:56:51
 */
public class leetcode_134 {
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas.length == 1) {
      return 0;
    }
    int[] p = new int[gas.length];
    for (int i = 0; i < gas.length; i++) {
      p[i] = gas[i] - cost[i];
    }
    int totalCost = 0;
    int curGas = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i++) {
      totalCost += p[i];
      curGas += p[i];
      if (curGas < 0) {
        start = i + 1;
        curGas = 0;
      }
    }
    return (totalCost >= 0) ? start : -1;
  }
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(a, b));
  }
}
