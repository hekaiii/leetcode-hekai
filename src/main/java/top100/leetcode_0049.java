package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/7/1
 */
public class leetcode_0049 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String s = new String(chars);
      if (!map.containsKey(s)) {
        map.put(s, new ArrayList<>());
      }
      map.get(s).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public List<List<String>> groupAnagrams01(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      int[] count = new int[26];
      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }
      // 将频率数组转换成字符串作为 key
      StringBuilder keyBuilder = new StringBuilder();
      for (int num : count) {
        keyBuilder.append(num).append('#');  // # 分隔，防止 "11" 和 "1#1" 混淆
      }
      String key = keyBuilder.toString();
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

      map.computeIfAbsent(key, str -> new ArrayList<>())
          .add(s);
    }
    return new ArrayList<>(map.values());
  }
  public static void main(String[] args) {


  }
}
