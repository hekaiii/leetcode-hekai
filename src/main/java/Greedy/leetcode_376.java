package Greedy;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2025-02-05 19:53:42
 */
public class leetcode_376 {
  public static int wiggleMaxLength(int[] nums) {
    if (nums.length == 1) {
      return 1;
    }
    if (nums.length == 2) {
      if (nums[0] == nums[1]) {
        return 1;
      } else {
        return 2;
      }
    }
    int result = 1;
    int prediff = 0;
    int curdiff = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      curdiff = nums[i + 1] - nums[i];
      if ((prediff <= 0) && (curdiff > 0) || (prediff >= 0) && (curdiff < 0)) {
        result++;
        prediff =
      }
    }
    return result;
  }

  //分治
  private int wiggleMaxLength(int[] nums, int left, int right) {
    // 基本情况：单个元素，返回长度1
    if (left == right) return 1;

    // 分治：划分左右部分
    int mid = (left + right) / 2;
    int leftLength = wiggleMaxLength(nums, left, mid);
    int rightLength = wiggleMaxLength(nums, mid + 1, right);

    // 合并：检查中间元素的摆动性
    boolean isWiggle = (nums[mid] < nums[mid + 1] && nums[mid - 1] > nums[mid])
        || (nums[mid] > nums[mid + 1] && nums[mid - 1] < nums[mid]);

    // 如果中间存在摆动，拼接两部分
    if (isWiggle) {
      return leftLength + rightLength - 1;  // 中间重叠部分只算一次
    } else {
      return Math.max(leftLength, rightLength);  // 无法拼接，取两者最大
    }
  }
  public static void main(String[] args) {

  }
}
