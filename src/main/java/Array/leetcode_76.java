package Array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/8/21
 */
public class leetcode_76 {
  public static void main(String[] args) {
    String s = "cabwefgewcwaefgcf";
    String t = "cae";

    System.out.println(minWindow03(s, t));
  }
  //失败
  public static String minWindow01(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    char[] tCharArray = t.toCharArray();
    for (int i = 0; i < tCharArray.length; i++) {
      if (map.containsKey(tCharArray[i])) {
        map.put(tCharArray[i], map.get(tCharArray[i]) + 1);
      } else {
        map.put(tCharArray[i], 1);
      }
    }
    String ans = "";
    Integer ansNum = Integer.MAX_VALUE;
    int start = 0;
    LinkedList<Integer> starts = new LinkedList<>();
    char[] sCharArray = s.toCharArray();
    HashMap<Character, Integer> circle = new HashMap<Character, Integer>();
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      circle.put(entry.getKey(), entry.getValue());
    }
    for (int fast = 0; fast < sCharArray.length; fast++) {
      if (map.containsKey(sCharArray[fast])) {
        if (!starts.contains(fast)) {
          starts.add(fast);
        }
        if (circle.getOrDefault(sCharArray[fast],0) == 1) {
          circle.remove(sCharArray[fast]);
          if (circle.size() == 0) {
            if ((fast - start + 1) < ansNum) {
              ansNum = fast - start + 1;
              ans = s.substring(start, fast + 1);
            }
            starts.removeFirst();
            fast = starts.getFirst();
            start = starts.getFirst();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
              circle.put(entry.getKey(), entry.getValue());
            }
            circle.remove(sCharArray[fast]);
          }
        } else if (circle.getOrDefault(sCharArray[fast],0) > 1){
          circle.put(sCharArray[fast], circle.get(sCharArray[fast]) - 1);
        }
      }
    }
    return ans;
  }
  public static String minWindow02(String s, String t) {
    // 边界情况，如果 t 比 s 长，直接返回空字符串
    if (s.length() < t.length()) {
      return "";
    }

    // 使用两个哈希表，一个存储 t 中字符的需求，一个存储当前窗口中字符的情况
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    // 初始化 need 字典
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    int start = 0, minLen = Integer.MAX_VALUE;

    while (right < s.length()) {
      // 将字符加入窗口
      char c = s.charAt(right);
      right++;

      // 如果这个字符是 t 所需的，更新 window 字典
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }

      // 当所有字符都匹配时，开始收缩左边界
      while (valid == need.size()) {
        // 更新最小子串的长度
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }

        char d = s.charAt(left);
        left++;

        // 如果离开窗口的字符是 t 所需的，更新 window 字典
        if (need.containsKey(d)) {
          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }

    // 如果找到了有效的最小覆盖子串，返回它；否则返回空字符串
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
  }

  public static String minWindow03(String s, String t){
    if (t.length() > s.length()) {
      return "";
    }
    HashMap<Character, Integer> needs = new HashMap<>();
    HashMap<Character, Integer> windows = new HashMap<>();

    for (char c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    int slow = 0;
    int start = 0;
    int ansLength = Integer.MAX_VALUE;
    int valid = 0;
    for (int fast = 0; fast < s.length(); fast++) {
      char c = s.charAt(fast);
      if (needs.containsKey(c)) {
        windows.put(c, windows.getOrDefault(c, 0) + 1);
        if (windows.get(c) == needs.get(c)) {
          valid++;
        }
      }
      while (valid == needs.size()) {
        if (ansLength > (fast - slow + 1)) {
          ansLength = fast - slow + 1;
          start = slow;
        }

        char d = s.charAt(slow);
        slow++;
        if (needs.containsKey(d)) {
          if (windows.get(d).equals(needs.get(d))) {
            valid--;
          }
          windows.put(d, windows.get(d) - 1);
        }
      }
    }
    return ansLength == Integer.MAX_VALUE ? "" : s.substring(start, start + ansLength);
  }
}
