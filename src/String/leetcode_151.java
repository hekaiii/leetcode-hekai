package String;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/16 1:21
 */
public class leetcode_151 {
    public static void main(String[] args) {
        String b = " asdasd df f";
        System.out.println(b.substring(11));
        String s = reverseWords(" asdasd df f ");
        System.out.println(s);
    }
    public static String reverseWords(String s) {
        s = s + " ";
        LinkedList<String> str = new LinkedList<>();
        char[] chars = s.toCharArray();
        int start = 0;
        for (int end = 1; end < chars.length; end++) {
            if (chars[end] == ' ' && chars[end - 1] != ' ') {
                str.add(s.substring(start, end));
            } else if (chars[end] != ' ' && chars[end - 1] == ' ') {
                start = end;
            } else if (end == chars.length - 1 && chars[end] != ' ') {
                str.add(s.substring(start));
            }
        }
        System.out.println(str.toString());
        StringBuffer sb = new StringBuffer(str.size());
        for (int i = str.size() - 1; i >= 0; i--) {
            sb.append(str.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
