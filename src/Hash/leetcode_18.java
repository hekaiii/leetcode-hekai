package Hash;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/4 10:54
 */
public class leetcode_18 {
    public static void main(String[] args) {
        int[] ints = {-2,-1,-1,1,1,2,2};
        leetcode_18 leetcode_18 = new leetcode_18();
        List<List<Integer>> lists = leetcode_18.fourSum(ints, 0);
        System.out.println(lists);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        ArrayList<List<Integer>> res1 = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {

                        left++;
                    } else {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(integers);
                        while (right > left && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right-1]) {
                            right--;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        for (List<Integer> a : res) {
            res1.add(a);
        }
        return res1;
    }
}
