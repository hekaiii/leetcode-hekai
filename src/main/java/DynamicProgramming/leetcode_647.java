package DynamicProgramming;

import java.sql.Struct;

/**
 * @author hekai
 * @date 2025/6/2 00:11
 * @description TODO
 */
public class leetcode_647 {
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                        result++;
                    }
                    if (j - i > 2 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abbba";
        System.out.println(countSubstrings(s));
    }
}
