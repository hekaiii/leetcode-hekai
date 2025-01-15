package TwoPointers;

import java.util.Stack;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/11/5
 */
public class leetcode151 {

  //未优化前的解
  public static String reverseWords(String s) {
    if (s.length() == 1) {
      if (s.charAt(0) == ' ') {
        return "";
      } else {
        return s;
      }
    }
    s = s + " ";
    Stack<String> strings = new Stack<>();
    int right = -1;
    int fast = 0;
    while (fast < s.length()) {
      if (s.charAt(fast) == ' ') {
        if (right == -1) {
          fast++;
        } else if (right != -1) {
          strings.push(s.substring(right, fast));
          right = -1;
        }
      } else {
        if (right == -1) {
          right = fast;
        } else {
          fast++;
        }
      }
    }
    String result = "";
    while (strings.iterator().hasNext()) {
      result = result + strings.pop()+" ";
    }
    return result.substring(0, result.length() - 1);
    }

  /**
   gpt优化后的解
   1.为解决单词倒叙问题，选择从后往前遍历
   2.使用stringbuilder而不是stack 效率更高
   *
   */

  public static String reverseWords01(String s) {
    // 去除多余空格
    s = s.trim();
    StringBuilder result = new StringBuilder();
    int end = s.length();

    // 从后往前扫描字符串
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        // 碰到空格，截取并添加单词
        if (i != end - 1) {
          result.append(s.substring(i + 1, end)).append(" ");
        }
        end = i;
      } else if (i == 0) {
        // 到达第一个字符
        result.append(s.substring(i, end)).append(" ");
      }
    }
    // 去掉最后一个多余的空格
    return result.toString().trim();
  }

  public static String reverseWords02(String s) {
    s = s.trim();
    StringBuilder sb = new StringBuilder();
    int end = s.length() - 1;
    // int end = s.length();

    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        if (end == s.length() - 1) {
          //第一个单词
          sb.append(s.substring(i + 1, s.length())+" ");
          end = i;
        } else {
          if (i == end - 1) {
            end = i;
          } else {
            sb.append(s.substring(i + 1, end)+" ");
            end = i;
          }
        }
      }
      if (i == 0) {
        if (end == s.length() - 1) {
          sb.append(s.substring(0, s.length()));
        } else {
          sb.append(s.substring(0, end));
        }

      }
    }
    return sb.toString();
  }
  public static void main(String[] args) {

    String str = "EPY2giL";
    System.out.println(reverseWords02(str));
//    String str = "  abc   b c";
//    System.out.println(str.trim());
  }
  }
