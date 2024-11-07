package TwoPointers;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/11/4
 */
public class leetcode27 {
  public static int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return nums.length;
    } else if (nums.length == 1 && nums[0] == val) {
      return 0;
    } else if (nums.length == 1 && nums[0] != val) {
      return 0;
    }
    int slow = 0;
    int fast = 1;
    while (fast < nums.length-1) {
      if (nums[slow] == val && fast != (nums.length - 1)) {
        while (fast < nums.length && nums[fast] == val) {
          fast++;
        }
        if (fast < nums.length) {
          if (nums[fast] != val) {
            nums[slow] = nums[fast];
            nums[fast] = val;
            slow++;
            fast++;
          }
        }
      } else {
        slow++;
        fast = slow + 1;
      }
    }
    return slow;
  }

  public static int removeElement01(int[] nums, int val) {
    int slow = 0;
    int fast = 0;
    int n = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (nums[fast] == val) {
        n--;
      } else {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return n;
  }

  public static int removeElement02(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      if (nums[0] == val) {
        return 0;
      } else {
        return 1;
      }
    }
    int right = 0;
    int left = 0;
    int n = nums.length;
    while (left < nums.length) {
      if (nums[left] == val) {
        left++;
        n--;
      } else {
        nums[right] = nums[left];
        right++;
        left++;
      }
    }
    return n;
  }
  public static void main(String[] args) {
    int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
    int i = removeElement02(ints,2);
    System.out.println(i);
  }
}
