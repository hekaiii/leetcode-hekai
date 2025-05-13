package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/5/12
 */
public class leetcode_139 {
  public static boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> wordSet = new HashSet<>(wordDict);
    //dp[j]的含义 前j个字符串能否被字典表示 能表示true 不能表示false
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    //本题题目要求的是排列 排列：先包在物品
    for (int j = 1; j <= s.length(); j++) {
      for (int i = 0; i < j; i++) {
        if (wordSet.contains(s.substring(i, j)) && dp[j - (j - i)] == true) {
          dp[j] = true;
          //优化
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    String s = "catsandog";
    List<String> str = new ArrayList<>();
    str.add("cats");
    str.add("dog");
    str.add("sand");
    str.add("and");
    str.add("cat");
    System.out.println(wordBreak(s, str));
  }
}
