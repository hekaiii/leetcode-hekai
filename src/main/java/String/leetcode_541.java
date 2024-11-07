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


    public static String reverseStr01(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i += 2 * k) {
            int left = i;
            int right = Math.min(left + k - 1, charArray.length - 1);
            while (right > left) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                right--;
                left++;
            }
        }
        return new String(charArray);
    }
    public static void main(String[] args) {

    }
}
