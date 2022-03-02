package Hash;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/3/2 23:54
 */
public class leetcode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        String res = "";
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        int[] a = new int[set1.size()];
        int index = 0;
        for (Integer integer : set1) {
            a[index++] = integer;
        }
        return a;
    }
}
