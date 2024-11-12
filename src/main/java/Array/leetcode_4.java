package Array;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/11/8
 */
public class leetcode_4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int value = (n + m) % 2;
    double result = 0;
    if (value == 0) {
      int mid = (n + m) / 2;
      for (int i = 0; i < mid; i++) {

      }
    } else if (value == 1) {
      int mid = (n + m) / 2 + 1;
      int a = 0;
      int b = 0;
      for (int i = 0; i < mid; i++) {
        if (nums1[a] >= nums2[b]) {
          if (b < nums2.length) {
            b++;
          } else {
            a++;
          }
        } else {
          if (a < nums1.length) {
            a++;
          } else {
            b++;
          }
        }
      }
      result = Math.min(nums1[a], nums2[b]);
    }
    return result;
  }
  public static void main(String[] args) {

  }
}
