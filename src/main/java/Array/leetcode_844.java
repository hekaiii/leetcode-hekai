package Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 12:52
 */
public class leetcode_844 {
    public static void main(String[] args) {
//        boolean a = backspaceCompare02("ab####c","ad##c");
        boolean b = backspaceCompare02("ab##","c#d#");
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

    public static boolean backspaceCompare01(String s, String t) {
        return false;
    }

    public static boolean backspaceCompare02(String s, String t){
        return removeSharp03(s).equals(removeSharp03(t));
    }
    public static String removeSharp01(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < ss.length; fast++) {
            if (ss[fast] != '#') {
                slow++;
            } else if (ss[fast] == '#') {
                if (slow > 0) {
                    ss[slow - 1] = '#';
                    slow++;
                } else if (slow == 0){
                    ss[slow] = '#';
                }
            }
        }
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i] != '#') {
                sb.append(ss[i]);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static String removeSharp02(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        int count = 0;
        for (int fast = ss.length - 1; fast >= 0; fast--) {
            if (ss[fast] == '#') {
                count++;
            }else {
                if (count > 0) {
                    count--;
                } else if (count == 0) {
                    sb.append(ss[fast]);
                }
            }
        }
        return sb.toString();
    }

    //堆栈
    public static String removeSharp03(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != '#') {
                sb.append(ss[i]);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}
