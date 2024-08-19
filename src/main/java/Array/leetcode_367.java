package Array;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2023/8/15
 */
public class leetcode_367 {

  public static void main(String[] args) {
    System.out.println(isPerfectSquare(5));
  }

  public static boolean isPerfectSquare(int num) {
    int left = 0, right = num;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      int square =mid * mid;
      if (square < num) {
        left = mid + 1;
      } else if (square > num) {
        right = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }

  public static boolean isPerfectSquare01(int num) {
    if (num == 1 || num == 0) {
      return true;
    }
    long left = 1;
    long right = num / 2;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (mid < num / mid) {
        left = mid + 1;
      } else if (mid > num / mid) {
        right = mid - 1;
      }
    }
      return left*left == num;
  }

  public static boolean isPerfectSquare02(int num){
    if (num == 1) {
      return true;
    }
    int l = 1;
    int r = num / 2;
    while (r >= l) {
      int mid = l + (r - l) / 2;
      long res = (long) mid * mid;
      if (res > num) {
        r = mid - 1;
      } else if (res < num) {
        l = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
