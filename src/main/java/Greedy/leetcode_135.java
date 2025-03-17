package Greedy;

import java.util.Arrays;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-17 20:08:22
 */
public class leetcode_135 {
  public static int candy(int[] ratings) {
    if (ratings.length == 1) {
      return 1;
    }
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      }
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
    }
    int result = 0;
    for (int candy : candies) {
      result += candy;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 2, 2, 1};
    System.out.println(candy(a));
  }
}
