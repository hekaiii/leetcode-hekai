package Array;

import jdk.internal.util.xml.impl.ReaderUTF8;
import jdk.nashorn.internal.ir.ReturnNode;

import javax.swing.text.TabExpander;
import java.awt.font.TextAttribute;
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
        int[] a = {-1, 0, 3, 5, 9, 12};
        int b = search2(a, 2);
        System.out.println(b);
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

    //左闭右闭
    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }

    //左闭右开
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
