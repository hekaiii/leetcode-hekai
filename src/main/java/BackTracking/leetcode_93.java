package BackTracking;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/1/8
 */
public class leetcode_93 {
  public static List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    if (s.length() < 4 || s.length() > 12) {
      return result;
    }
    backTracking(s, 0, new ArrayList<>(), result);
    return result;
  }

  private static void backTracking(String s, int start, List<String> list, List<String> result) {
    if (start == s.length() && list.size() == 4) {
      result.add(String.join(".", list));
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (list.size() >= 4 || (i - start) > 3) {
        break;
      }
      String str = s.substring(start, i + 1);
      int i1 = Integer.parseInt(str);
      if (0 <= i1 && i1 <= 255) {
        if (str.length() > 1 && str.charAt(0) == '0') {
        } else {
          list.add(s.substring(start, i + 1));
          backTracking(s, i + 1, list, result);
          list.remove(list.size() - 1);
        }
      }
    }
  }


  public static void main(String[] args) {
    List<String> s = restoreIpAddresses("101023");
    for (String string : s) {
      System.out.println(string);
    }
  }

}
