package MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/3
 */
public class leetcode_496 {

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for (int i : nums2) {
      while (!stack.isEmpty() && stack.peek() < i) {
        map.put(stack.pop(), i);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      map.put(stack.pop(), -1);
    }
    for (int i = 0; i < nums1.length; i++) {
      result[i] = map.get(nums1[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1,3,5,2,4};
    int[] nums2 = new int[]{6,5,4,3,2,1,7};
    int[] ints = nextGreaterElement(nums1, nums2);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }
}
