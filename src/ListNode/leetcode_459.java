package ListNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/16 19:55
 */
public class leetcode_459 {
    public static void main(String[] args) {
        leetcode_459 leetcode_459 = new leetcode_459();

        boolean abab = leetcode_459.repeatedSubstringPattern("ababac");

    }
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next, s);
//        Arrays.sort(next);
        if (next[s.length() - 1] < 1) {
            return false;
        }
        int doublel = next[s.length() - 1];
        if (s.length() % (s.length() - doublel) == 0) {
            return true;
        }
        return false;
    }

    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
