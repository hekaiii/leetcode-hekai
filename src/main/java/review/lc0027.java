package review;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2025/6/5
 */
public class lc0027 {
  public static int removeElement(int[] nums, int val) {
    int result = nums.length;
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] == val) {
        result--;
      } else {
        nums[slow++] = nums[fast];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(removeElement(new int[]{3, 3, 3, 3}, 3));

  }
}
