package Array;

import javax.print.DocFlavor;
import javax.swing.plaf.PanelUI;
import javax.xml.transform.Result;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/22 19:52
 */
public class leetcode_209 {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,2,4,3};
        int i = minSubArrayLen01(7, a);
        System.out.println(i);
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
}
