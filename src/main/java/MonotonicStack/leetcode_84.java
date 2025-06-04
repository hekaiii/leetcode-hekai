package MonotonicStack;

import com.sun.org.glassfish.external.amx.AMX;

import java.util.Stack;

/**
 * @author hekai
 * @date 2025/6/3 22:40
 * @description TODO
 */
public class leetcode_84 {
    public static int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }
}
