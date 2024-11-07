package Hash;

import java.util.HashSet;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/10/11
 */
public class leetcode_202 {
  //垃圾解
  public static boolean isHappy(int n) {
    int result;
    HashSet<Object> set = new HashSet<>();
    set.add(n);
    do {
      n = solve(n);
      if (n == 1) {
        return true;
      }
      set.add(n);
    } while (!set.contains(solve(n)));
    return false;
  }

  public static Integer solve(int n) {
    int result = 0;
    String s = String.valueOf(n);
    char[] num = s.toCharArray();
    for (int i = 0; i < num.length; i++) {
      result += Integer.parseInt(num[i]+"")*Integer.parseInt(num[i]+"");
    }
    return result;
  }
  public static boolean isHappy01(int n) {
    int slow=n;
    int fast = getNext(n);
    while (slow!=fast) {
      slow = getNext(slow);
      fast = getNext(getNext(fast));
    }
    if (slow == 1) {
      return true;
    } else {
      return false;
    }
  }

  public static int getNext(int n) {
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      sum += digit * digit;
      n /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(isHappy01(1111111));
//    System.out.println(getNext(1111111));
  }
}
