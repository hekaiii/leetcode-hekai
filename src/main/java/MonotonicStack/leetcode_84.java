package MonotonicStack;

import java.util.Stack;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/4
 */
public class leetcode_84 {
  public static int largestRectangleArea(int[] heights){
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i <= heights.length; i++) {
      int curHeight = i == heights.length ? 0 : heights[i];
      while (!stack.isEmpty() && heights[stack.peek()] > curHeight) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        result = Math.max(result, height * width);
      }
      stack.push(i);
    }
    return result;
  }
  public static void main(String[] args) {
    int[] heights = new int[]{2, 1, 5, 6, 2, 3};
    System.out.println(largestRectangleArea(heights));
  }
}
