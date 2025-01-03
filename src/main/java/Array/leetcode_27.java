package Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/21 23:48
 */
public class leetcode_27 {
    public static void main(String[] args) {
        int[] a = new int[]{2};
        int i = removeElement6(a, 3);
        System.out.println(i);
    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < len; j++) {
                    nums[j - 1] = nums[j];
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

    public static int removeElement3(int[] nums, int val) {
        int newSize = 0;
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[low++] = nums[i];
                newSize++;
            }
        }
        return newSize;
    }

    public static int removeElement4(int[] nums, int val){
        int result = nums.length;
        for (int i = 0; i < result; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                result--;
                i--;
            }
        }
        return result;
    }


    public static int removeElement6(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] == val) {
                fast++;
                count--;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return count;
    }
}
