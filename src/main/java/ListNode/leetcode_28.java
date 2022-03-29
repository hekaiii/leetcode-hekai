package ListNode;

import java.util.jar.JarEntry;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/16 17:08
 */
public class leetcode_28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int start = 0;
        for (int end = 0; end < haystack.length(); end++) {
            while (start > 0 && needle.charAt(start) != haystack.charAt(end)) {
                start = next[start - 1];
            }
            if (needle.charAt(start) == haystack.charAt(end)) {
                start++;
            }
            if (start == needle.length()) {
                return end - start + 1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String needle) {
        char[] chars = needle.toCharArray();
        int start = 0;
        next[0] = 0;
        for (int end = 1; end < chars.length; end++) {
            while (start > 0 && chars[end] != chars[start]) {
                start = next[start - 1];
            }
            if (chars[end] == chars[start]) {
                start++;
            }
            next[end] = start;
        }
    }
}
