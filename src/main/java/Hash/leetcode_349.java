package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

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


  //垃圾方法
    public static int[] intersection01(int[] nums1, int[] nums2) {
    ArrayList<Integer> integers = new ArrayList<>();
    HashSet set = new HashSet<Integer>();
    for (int s1 : nums1) {
      set.add(s1);
    }
    for (int s2 : nums2) {
      if (set.contains(s2) && !integers.contains(s2)) {
        integers.add(s2);
      }
    }
    Iterator<Integer> iterator = integers.iterator();
    int[] result = new int[integers.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = iterator.next();
    }
    return result;
  }

    public static int[] intersection02(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int s1 : nums1) {
            set1.add(s1);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int s2 : nums2) {
            if (set1.contains(s2)) {
                set2.add(s2);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (int a : set2) {
            result[index++] = a;
        }
        return result;
    }
    public static void main(String[] args) {
       int[] nums1 = {4, 9, 5};
       int[] nums2 = {9, 4, 9, 8, 4};
       int[] ints = intersection02(nums1, nums2);
       System.out.println(Arrays.toString(ints));
     }
}
