package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/4 10:08
 * hashmap+双指针
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

    public static List<List<Integer>> threeSum01(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums[0] > 0) {
            return result;
        }
        for (int a = 0; a <= nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum > 0) {
                    c--;
                } else if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[a], nums[b], nums[c]);
                    result.add(list);
                    while (b < c && nums[b] == nums[b+1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c-1]) {
                        c--;
                    }
                    c--;
                    b++;
                } else if (sum < 0) {
                    b++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums01 = {-1, 0, 1, 2, -1, -4};
        int[] nums02 = {0, 0, 0};
        int[] nums04 = {0, 0, 0,0};
        int[] nums03 = {0, 1, 1};
        List<List<Integer>> lists = threeSum01(nums01);
        for (List<Integer> a : lists) {
            for (Integer b : a) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}
