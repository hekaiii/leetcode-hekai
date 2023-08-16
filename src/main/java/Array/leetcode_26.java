package Array;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2023/8/16
 */
public class leetcode_26 {

  public int removeDuplicates(int[] nums) {
    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[slow] != nums[fast]) {
        nums[++slow] = nums[fast];
      }
    }
    return slow + 1;
  }

}
