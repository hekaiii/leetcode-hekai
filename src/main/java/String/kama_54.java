package String;

import java.util.Scanner;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/10/16
 */
public class kama_54 {

  public static String changeNumber(String s) {
    char[] charArray = s.toCharArray();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < charArray.length; i++) {
      if ('0' <= charArray[i] && charArray[i] < '9') {
        sb.append("number");
      } else {
        sb.append(charArray[i]);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] charArray = sc.next().toCharArray();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < charArray.length; i++) {
      if ('0' <= charArray[i] && charArray[i] <= '9') {
        sb.append("number");
      } else {
        sb.append(charArray[i]);
      }
    }
    System.out.println(sb.toString());
  }
}
