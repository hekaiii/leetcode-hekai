package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-03-23 14:25:57
 */
public class leetcode_763 {
  public static List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    if (s.length() == 1) {
       result.add(1);
      return result;
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      HashSet<Character> same = new HashSet<Character>();
      int start = i;
      int end = i;
      for (int j = s.length() - 1; j >= start; j--) {
        if (s.charAt(j) == c) {
          end = j;
          break;
        }
      }
      if (start == end) {
        result.add(1);
        continue;
      } else {
        same.add(c);
        for (int j = start + 1; j <= end; j++) {
          if (same.contains(s.charAt(j))) {
            continue;
          }
          for (int k = s.length() - 1; k >= end + 1; k--) {
            if (s.charAt(k) == s.charAt(j)) {
              end = Math.max(end, k);
            }
          }
        }
        result.add(end + 1 - start);
        i = end;
      }
    }
    return result;
  }

  public static List<Integer> partitionLabels01(String s) {
    int[] last = new int[26];
    Arrays.fill(last, 0);
    for (int i = 0; i < s.length(); i++) {
      last[s.charAt(i) - 'a'] = i;
    }
    System.out.println(Arrays.toString(last));
    List<Integer> res = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      end = Math.max(end, last[s.charAt(i) - 'a']);
      if (i == end) {
        res.add(end - start + 1);
        start = i + 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<Integer> a = partitionLabels01("eccbbbbdec");
    System.out.println(a);
  }
}
