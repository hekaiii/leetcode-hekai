package Hash;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 23:26
 */
public class leetcode_242 {
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c1.length; i++) {
            if (!map.containsKey(c1[i])) {
                map.put(c1[i], 1);
            } else {
                Integer count = map.get(c1[i]);
                count++;
                map.put(c1[i], count);
            }
        }
        for (int i = 0; i < c2.length; i++) {
            if (!map.containsKey(c2[i])) {
                return false;
            } else {
                Integer count = map.get(c2[i]);
                map.put(c2[i], --count);
            }
        }
        Boolean flag = true;
        for (Character character : map.keySet()) {
            Integer integer = map.get(character);
            if (integer != 0) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean isAnagram01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] list = new int[26];
        for (int i = 0; i < 26; i++) {
            list[s.charAt(i) - 'a']++;
            list[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (list[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
