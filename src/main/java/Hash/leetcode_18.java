package Hash;

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
    public static List<List<Integer>> fourSum01(int[] nums, int target) {
        Arrays.sort(nums);
        //合法性判断
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    long sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c+1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d-1]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                    if (sum > target) {
                        d--;
                    }
                    if (sum < target) {
                        c++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1,0,-1,0,-2,2};
        int[] ints1 = {1,-2,-5,-4,-3,3,3,5};
        int[] ints2 = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = fourSum01(ints2,-294967296);
        for (List<Integer> a : lists) {
            for (Integer b : a) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}
