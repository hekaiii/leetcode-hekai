package test;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/10/9
 */
public class BubbleSort {

  public static void sort(int[] array) {
    // 冒泡排序的实现
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }
  public static void main(String[] args) {
    int[] list = {10, 2, 13, 4};
    sort01(list);
    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i]);
    }
  }

  public static void sort01(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }
}
