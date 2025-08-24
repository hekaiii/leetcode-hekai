package top100;

/**
 * @Author: hek32
 * @Description: 收缩窗口
 * @Date: 2025/7/2
 */
public class leetcode_0011 {
  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int result = 0;
    while (right > left) {
      int h = Math.min(height[left], height[right]);
      int w = right - left;
      result = Math.max(result, w * h);
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
