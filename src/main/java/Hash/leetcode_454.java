package Hash;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/3 21:37
 */
public class leetcode_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int flag = 0;
        int n = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(nums1[i] + nums2[j])) {
                    map.put(nums1[i] + nums2[j], 1);
                } else {
                    Integer integer = map.get(nums1[i] + nums2[j]);
                    map.put(nums1[i] + nums2[j], ++integer);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(0 - (nums3[i] + nums4[j]))) {
                    flag += map.get(0 - (nums3[i] + nums4[j]));
                }
            }
        }
        return flag;
    }

    //垃圾解
    public int fourSumCount01(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map1.put(nums1[i] + nums2[j], map1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map2.put(nums3[i] + nums4[j], map2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }
        int result = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(-key)) {
                result += map2.get(-key)*map1.get(key);
            }
        }
        return result;
    }


    public int fourSumCount02(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -(nums3[i] + nums4[j]);
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
