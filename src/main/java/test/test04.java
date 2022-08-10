package test;

import java.util.Arrays;

/**
 * @Date: 2022/4/24 22:57
 */
public class test04 {
    public static void main(String[] args) {
        String change = Change("125235");
        System.out.println(change);
    }

    public static String Change(String str) {
        int[] arr = new int[str.length()];
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.charAt(i)+"");
            result[i] = str.charAt(i);
        }
        Arrays.sort(arr);
        int indexValue1 = 0;
        int indexValue2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1 - i] != Integer.parseInt(str.charAt(i) + "")) {
                indexValue1 = i;
                indexValue2 = str.indexOf(arr[arr.length - 1 - i]+"",0);
                break;
            }
        }
        char temp = result[indexValue1];
        result[indexValue1] = result[indexValue2];
        result[indexValue2] = temp;
        return String.valueOf(result);
    }
}
