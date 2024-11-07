package Hash;

import java.util.HashMap;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/10/11
 */
public class leetcode_383 {
  //垃圾解
  public static boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> map = new HashMap<>();
    char[] list1 = magazine.toCharArray();
    char[] list2 = ransomNote.toCharArray();
    for (char a : list1) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }
    for (char a : list2) {
      if (map.containsKey(a) && map.get(a) >= 1) {
        map.put(a, map.get(a) - 1);
        if (map.get(a) == 0) {
          map.remove(a);
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static boolean canConstruct01(String ransomNote, String magazine) {
    int[] ints = new int[26];
    for (Character c : magazine.toCharArray()) {
      ints[c - 'a'] += 1;
    }
    for (Character c : ransomNote.toCharArray()) {
      ints[c - 'a'] -= 1;
      if (ints[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    System.out.println(canConstruct("a", "b"));
  }
}
