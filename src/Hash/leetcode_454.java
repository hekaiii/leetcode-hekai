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
}
