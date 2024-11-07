package String;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/10/31
 */
public class leetcode_459 {
  public static boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    int index = 0;
    int i = 1;
    int[] ints = new int[n];
    ints[0] = 0;
    while (i < n) {
      if (s.charAt(i) == s.charAt(index)) {
        index++;
        ints[i] = index;
        i++;
      } else {
        if (index == 0) {
          ints[i] = 0;
          i++;
        } else {
          index = ints[index - 1];
        }
      }
    }
    int index1 = 0;
    for (int j = n-1; j >= 0; j--) {
      if (ints[j] == 1) {
        index1 = j;
        break;
      }
    }
    if ((ints[n - 1] + index1 == n)&&(n%index1==0)) {
      return true;
    } else {
      return false;
    }
  }


  public static boolean repeatedSubstringPattern01(String s) {
    int[] lps1 = lps(s);
    int len = lps1.length;
    return (lps1[len-1]>0) && ((len % (len - lps1[len - 1])) == 0);
  }

  public static int[] lps(String s) {
    int[] ints = new int[s.length()];
    ints[0] = 0;
    int index = 0;
    int i = 1;
    while (i < s.length()) {
      if (s.charAt(index) == s.charAt(i)) {
        index++;
        ints[i] = index;
        i++;
      } else {
        if (index == 0) {
          ints[i] = 0;
          i++;
        } else {
          index = ints[index - 1];
        }
      }
    }
    return ints;
  }
  public static void main(String[] args) {
    System.out.println(repeatedSubstringPattern01("abac"));
  }
}
