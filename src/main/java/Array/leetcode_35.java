package Array;

public class leetcode_35 {
    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 10, 12};
        int b = searchInsert(a, 2);
        System.out.println(b);
        System.out.println(3>>1);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[right]) {
            return right + 1;
        } else if (target < nums[left]) {
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left ;
    }
}
