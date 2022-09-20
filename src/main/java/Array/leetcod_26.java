package Array;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 10:58
 *
 */
public class leetcod_26 {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3,4,5,2};
        int i = removeDuplicates(a);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast-1]) {
                fast++;
            } else {
                nums[slow]=nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
    public static int removeDuplicates1(int[] nums) {
        HashMap hashMap = new HashMap();
        int low = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                nums[low++] = nums[i];
                hashMap.put(nums[i], 1);
                count++;
            }
        }
        return count;
    }
}
