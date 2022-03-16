package test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/10 23:04
 */
public class leetcode_11 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(a);
        System.out.println(i);
    }
    public static int maxArea(int[] height) {
        if (height.length <= 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        while (end > start) {
            int min = Math.min(height[start], height[end]);
            int nowres = min * (end - start);
            res = res < nowres ? nowres : res;
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
