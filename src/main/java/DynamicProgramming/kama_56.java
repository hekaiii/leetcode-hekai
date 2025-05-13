package DynamicProgramming;

import java.util.Scanner;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/12
 */
public class kama_56 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int space = sc.nextInt();
    int kinds = sc.nextInt();
    int[] weights = new int[kinds];
    int[] values = new int[kinds];
    int[] nums = new int[kinds];
    for (int i = 0; i < weights.length; i++) {
      weights[i] = sc.nextInt();
    }
    for (int i = 0; i < weights.length; i++) {
      values[i] = sc.nextInt();
    }
    for (int i = 0; i < weights.length; i++) {
      nums[i] = sc.nextInt();
    }



  }
}
