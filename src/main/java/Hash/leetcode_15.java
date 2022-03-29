package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/4 10:08
 */
public class leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> al01 = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(al01);
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right < left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right++;
                    left++;
                }
            }
        }
        return res;
    }
}
