package Array;

import jdk.internal.util.xml.impl.ReaderUTF8;

import java.security.Key;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/10 22:23
 */
public class leetcode_704 {
    public static void main(String[] args) {
        int[] a =new int[]{1,2,3,4,5};
        int search = search(a,1);
        System.out.println(search);
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (right >= left) {
            int mid = (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {

        return 0;
    }
}
