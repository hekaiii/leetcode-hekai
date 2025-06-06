package test;

import java.util.Arrays;

/**
 * @Date: 2022/4/19 10:23
 */
public class QuickSort {
    public static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }

        }
        System.out.println("遍历结束"+Arrays.toString(array));
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            // 左子数组递归调用
            quickSort(array, low, position -1);
            // 右子数组递归调用
            quickSort(array, position + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 8, 6, 3, 9, 2, 1, 7 };
//        quickSort(array, 0, array.length -1);
//        System.out.println("排序后的结果");
//        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length -1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort01(int[] array, int low, int high) {
        if (low < high) {
            int position = partition01(array, low, high);
            quickSort01(array, low, position - 1);
            quickSort01(array, position + 1, high);
        }
    }

    private static int partition01(int[] array, int low, int high) {
        int target = array[high];
        int pointer = 0;
        for (int i = 0; i < high; i++) {
            if (array[i]<=target) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
        }
        int temp = array[high];
        array[high] = array[pointer];
        array[pointer] = temp;
        return pointer;
    }
}
