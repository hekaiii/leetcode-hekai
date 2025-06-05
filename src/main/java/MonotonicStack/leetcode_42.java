package MonotonicStack;

import java.util.Stack;

/**
 * @author hekai
 * @date 2025/6/3 21:30
 * @description 单调栈
 */
public class leetcode_42 {
    public static int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int h = Math.min(height[i], height[stack.peek()]) - height[index];
                int w = i - stack.peek() - 1;
                result += h * w;
            }
            stack.push(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
