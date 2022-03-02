package Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 10:58
 *
 */
public class leetcod_26 {
    public int removeDuplicates(int[] nums) {
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
}
