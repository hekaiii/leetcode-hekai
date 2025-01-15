package StackAndQueue;

import java.util.Stack;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/12
 */
public class leetcode_1047 {

  public static String removeDuplicates(String s) {
    Stack<Character> chars = new Stack<>();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      if (chars.isEmpty()) {
        chars.push(c);
      } else if (c == chars.peek()) {
        chars.pop();
      } else {
        chars.push(c);
      }
    }
    char[] result = new char[chars.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = chars.pop();
    }
    return new String(result);
  }

  public static String removeDuplicates01(String s) {
    StringBuilder sb = new StringBuilder();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      if (sb.length() == 0) {
        sb.append(c);
      } else if (c == sb.charAt(sb.length()-1)) {
        sb.deleteCharAt(sb.length()-1);
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    System.out.println(removeDuplicates01("abbaca"));
  }
}
