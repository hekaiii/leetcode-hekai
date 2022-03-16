package String;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/4 15:09
 */
public class leetcode_344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            char tem = s[i];
            s[i] = s[j];
            s[j] = tem;
        }
    }
}
