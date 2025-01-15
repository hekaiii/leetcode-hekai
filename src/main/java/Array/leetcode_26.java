package Array;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2023/8/16
 */
public class leetcode_26 {

  public static void main(String[] args) {

  }
  public int removeDuplicates(int[] nums) {
    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[slow] != nums[fast]) {
        nums[++slow] = nums[fast];
      }
    }
    return slow + 1;
  }

  public int removeDuplicates01(int[] nums) {
    if (nums.length == 1) {
      return 1;
    }
    int slow = 0;
    int count = 1;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[slow] != nums[fast]) {
        nums[++slow] = nums[fast];
        count++;
      }
    }
    return count;
  }
}
