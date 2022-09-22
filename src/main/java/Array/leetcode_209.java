package Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/22 19:52
 */
public class leetcode_209 {
    public static void main(String[] args) {
//        int[] a = new int[]{1,2,3,4,5};
//        int i = minSubArrayLen04(11, a);
//        System.out.println(i);

        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            if (j > 0) {
                j = 1;
            }
        }
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
                return  1;
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

    public static int minSubArrayLen03(int target, int[] nums){
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

    public static int minSubArrayLen04(int target, int[] nums){
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
                i = start ;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
