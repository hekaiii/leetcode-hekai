package Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 12:36
 */
public class leetcode_283 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes3(a);
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

    public static void moveZeroes1(int[] nums) {
        int low = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[low++] = nums[i];
            }
        }
        for (int i = 1; i <= count; i++) {
            nums[nums.length - i] = 0;
        }
    }

    public static void moveZeroes2(int[] nums){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes3(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        if (count > 0) {
            for (int i = nums.length-count; i <nums.length ; i++) {
                nums[i] = 0;
            }
        }
    }
}
