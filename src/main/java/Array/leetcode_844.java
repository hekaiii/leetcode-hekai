package Array;

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
        String s1 = removeSharp(s);
        String t1 = removeSharp(t);
        return s1.equals(t1);
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

    public static boolean backspaceCompare1(String s, String t) {
        return false;
    }

    public static String removeSharp(String s) {
        char[] a = s.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (a[i] == '#') {
                count++;
            } else if (count != 0) {
                count--;
            } else if (count == 0) {
                sb.append(a[i]);
            }
        }
        return sb.toString();
    }
}
