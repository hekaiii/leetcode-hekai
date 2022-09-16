package Array;

import java.util.Arrays;

public class leetcode_34 {
    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(a, 7)));
    }

    public static int[] searchRange(int[] nums, int target) {
        //先查在不在
        int inOrNot = search(nums, target);
        if (inOrNot == -1) {
            return new int[]{-1,-1};
        } else {
            int leftrank = inOrNot;
            int rightrank = inOrNot;
            while ((leftrank - 1 >= 0) && nums[leftrank - 1] == target) {
                leftrank = leftrank - 1;
            }
            while ((rightrank + 1 <= nums.length - 1) && nums[rightrank + 1] == target) {
                rightrank += 1;
            }
            return new int[]{leftrank, rightrank};
        }
    }

    static int search(int[] nums, int target) {
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

}
