package Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/22 19:52
 */
public class leetcode_209 {

  public static void main(String[] args) {
        int[] a = new int[]{2,3,1,2,4,3};
//        int[] a = new int[]{2,3,1,6,4,3};
        int i = minSubArrayLen07(7, a);
        System.out.println(i);

//    for (int j = 0; j < 10; j++) {
//      System.out.println(j);
//      if (j > 0) {
//        j = 1;
//      }
//    }
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int Result = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return 1;
      }
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (sum >= target) {
          int nowResult = j - i + 1;
          if (nowResult < Result) {
            Result = nowResult;
          }
          break;
        }
      }
    }
    return Result == Integer.MAX_VALUE ? 0 : Result;
  }

  public static int minSubArrayLen01(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int start = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return 1;
      }
      sum += nums[i];
      while (sum >= target) {
        int sublen = i - start + 1;
        result = result > sublen ? sublen : result;
        sum -= nums[start++];
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

  public static int minSubArrayLen02(int target, int[] nums) {
    int result = 0;
    for (int slow = 0; slow < nums.length; slow++) {
      if (nums[slow] >= target) {
        return 1;
      } else if (nums[slow] < target && slow < nums.length - 1) {
        int count = nums[slow];
        int fast = slow + 1;
        while (count <= target) {
          if (count == target) {
            if (result == 0) {
              result = fast - slow;
              break;
            } else {
              int tmp = fast - slow;
              result = Math.min(tmp, result);
              break;
            }
          } else {
            if (fast < nums.length) {
              count += nums[fast++];
            } else if (fast == nums.length) {
              break;
            }
          }
        }
      } else if (slow == nums.length - 1 && nums[slow] < target) {
        break;
      }
    }
    return result;
  }

  public static int minSubArrayLen03(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int start = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return 1;
      }
      count += nums[i];
      while (count >= target) {
        int tmpRes = i - start + 1;
        result = result > tmpRes ? tmpRes : result;
        count -= nums[start++];
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

  public static int minSubArrayLen04(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int start = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return 1;
      }
      count += nums[i];
      while (count >= target) {
        int tmpRes = i - start + 1;
        result = result > tmpRes ? tmpRes : result;
        start++;
        count = nums[start];
        i = start;
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

  //2xfor
  public static int minSubArrayLen05(int target, int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = nums[i];
      if (nums[i] >= target) {
        return 1;
      }
      for (int j = i + 1; j < nums.length; j++) {
        count += nums[j];
        if (count >= target) {
          if (result == 0) {
            result = j - i + 1;
          } else {
            if ((j - i + 1) < result) {
              result = j - i + 1;
            }
          }
          break;
        }
      }
    }
    return result;
  }

  //滑动窗口
  public static int minSubArrayLen06(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int count = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] >= target) {
        return 1;
      }
      count += nums[right];
      while (count >= target) { //关键点 while而不是if
        result = Integer.min(result, right - left + 1);
        count -= nums[left];
        left++;
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

  public static int minSubArrayLen07(int target, int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return 1;
      }
    }
    if (nums.length == 1 && nums[0] < target) {
      return 0;
    }
    int res = 0;
    int slow = 0;
    int count = nums[0];
    for (int fast = 1; fast < nums.length; fast++) {
      count += nums[fast];
      if (count >= target && res == 0) {
        res = fast - slow + 1;
        count -= nums[slow++];
        while (count >= target) {
          res = Integer.min(res, (fast - slow + 1));
          count -= nums[slow++];
        }
      } else if (count >= target && res != 0) {
        res = Integer.min(res, (fast - slow + 1));
        count -= nums[slow++];
        while (count >= target) {
          res = Integer.min(res, (fast - slow + 1));
          count -= nums[slow++];
        }
      }
    }
    return res;
  }
}
