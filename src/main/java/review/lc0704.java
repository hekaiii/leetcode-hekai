package review;

/**
 * @Author: hek32
 * @Description:
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 * @Date: 2025/6/5
 */
public class lc0704 {
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    //左闭右开
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    //左闭右闭
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{5},5));
  }
}
