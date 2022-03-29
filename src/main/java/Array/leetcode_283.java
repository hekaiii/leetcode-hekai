package Array;

import com.sun.xml.internal.bind.v2.util.FatalAdapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 12:36
 */
public class leetcode_283 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(a.toString());
    }
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        for (int i = slow ; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
