package DynamicProgramming;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-04-10 08:07:33
 */
public class leetcode_70 {
  public static int climbStairs(int n) {
    if (n < 3) {
      return n;
    }
    int a = 1;
    int b = 2;
    int sum = 0;
    for (int i = 3; i <= n; i++) {
      sum = a + b;
      a = b;
      b = sum;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(3));
  }
}
