package String;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/4 15:13
 */
public class leetcode_541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, i + k - 1);
            while (end > start) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        b ^= a;
        a ^= b;
        b ^= a;
        System.out.println(a);
        System.out.println(b);
    }
}
