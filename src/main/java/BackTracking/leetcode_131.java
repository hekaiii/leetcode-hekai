package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/2
 */
public class leetcode_131 {
  public static List<List<String>> partition(String s) {
    List<String> list = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    backTracking(s, 0, list, result);
    return result;
  }

  private static void backTracking(String s, int start, List<String> list,
      List<List<String>> result) {
    if (start == s.length()) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (isMirror(s.substring(start, i + 1))) {
        list.add(s.substring(start, i + 1));
        backTracking(s, i + 1, list, result);
        list.remove(list.size() - 1);
      }
    }
  }

  private static boolean isMirror(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i) ) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    List<List<String>> aab = partition("aaab");
    for (List<String> strings : aab) {
      System.out.println(strings.toString());
    }
  }
}
