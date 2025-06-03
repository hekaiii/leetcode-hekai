package MonotonicStack;

import java.util.Stack;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/3
 */
public class leetcode_739 {

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        Integer pop = stack.pop();
        result[pop] = i - pop;
      }
      stack.push(i);
    }
    //默认为0 可以省略
//    while (!stack.isEmpty()) {
//      result[stack.pop()] = 0;
//    }
    return result;
  }
  public static void main(String[] args) {
    int[] str = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    int[] ints = dailyTemperatures(str);
    for (int anInt : ints) {
      System.out.print(anInt+" ");
    }
  }
}
