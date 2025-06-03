package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/3
 */
public class leetcode_503 {
  public static int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums.length * 2; i++) {
      int index = i % nums.length;
      while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
        result[stack.pop()] = nums[index];
      }
      stack.push(index);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 1};
    System.out.println(nextGreaterElements(nums));
  }
}
