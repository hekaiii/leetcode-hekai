package Array;

import com.sun.glass.ui.Size;

import javax.xml.crypto.dsig.keyinfo.KeyName;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/21 23:48
 */
public class leetcode_27 {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3,4,5,2};
        int i = removeElement2(a, 2);
        System.out.println(i);
    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < len; j++) {
                    nums[j-1] = nums[j];
                }
                i--;
                len--;
            }
        }
        return len;
    }
    public static int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
    public static int removeElement2(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
