package Array;

public class leetcode_34 {
    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 9, 10};
        int getleft = getleft(a, 8);
        System.out.println(getleft);
//        System.out.println(Arrays.toString(searchRange1(a, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {
        //先查在不在
        int inOrNot = search(nums, target);
        if (inOrNot == -1) {
            return new int[]{-1, -1};
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
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        System.out.println(leftBorder);
        int rightBorder = getRightBorder(nums, target);
        System.out.println(rightBorder);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    static int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    static int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    static int getleft(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                right = mid - 1;
                result = right;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return result;
    }
}
