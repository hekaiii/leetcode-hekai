package Array;

import com.sun.xml.internal.bind.v2.util.FatalAdapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 12:52
 */
public class leetcode_844 {
    public static void main(String[] args) {
        boolean b = leetcode_844.backspaceCompare("ab#c","ad#c");
        System.out.println(b);
    }
    public static boolean backspaceCompare(String s, String t) {
        String s_res = compareone(s);
        String t_res = compareone(t);
        return s_res.equals(t_res);
    }

    public static String compareone(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >=0; i--) {
            if (chars[i] == '#') {
                count++;
            } else if (count == 0) {
                sb.append(chars[i]);
            } else {
                count--;
            }
        }
        return sb.toString();
    }
}
