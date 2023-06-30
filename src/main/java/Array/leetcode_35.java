package Array;

public class leetcode_35 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int b = searchInsert2(a, 7);
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

    //二分法
    public static int searchInsert1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    //指针
    public static int searchInsert2(int[] nums, int target){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                result = i;
                break;
            } else if (nums[i] < target) {
                result++;
                continue;
            } else if (i == nums.length - 1 && nums[i] < target) {
                result = i + 1;
            }
        }
        return result;
    }

    int getLeft(int[] nums, int target){
        return 0;
    }

    int getRight(int[] nums, int target) {
        return 0;
    }





}
