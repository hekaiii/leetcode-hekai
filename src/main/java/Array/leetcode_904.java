package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class leetcode_904 {
    public static void main(String[] args) {
        int[] a = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int[] b = new int[]{1,2,1};
        int[] c = new int[]{1,2,3,2,2};
        int[] d = new int[]{0,1,1,4,3};
        System.out.println(totalFruit02(d));
    }
    public static int totalFruit(int[] fruits) {
        int start = 0;
        int count = 0;
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        if (fruits.length <= 2) {
            return fruits.length;
        }
        for (int i = 0; i < fruits.length; i++) {
            if (hm.size() < 2 && !hm.containsKey(fruits[i])) {
                hm.put(fruits[i], 1);
                count++;
                result = Math.max(count, result);
            } else if (hm.containsKey(fruits[i])) {
                count++;
                result = Math.max(count, result);
            } else if (!hm.containsKey(fruits[i])){
                result = Math.max(count, result);
                hm.clear();
                count = 0;
                if (start < fruits.length) {
                    i = start++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static int totalFruit01(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int n = tree.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < n; i++) {
            //HahMap.getOrDefault 有用！
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0){
                    map.remove(tree[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
    public static int totalFruit02(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }
        HashSet<Integer> ints = new HashSet<>();
        int slow = 0;
        int result = 0;
        ints.add(tree[0]);
        for (int i = 1; i < tree.length; i++) {
            if (ints.size() == 1 && !ints.contains(tree[i])) {
                ints.add(tree[i]);
                result=Integer.max(result, i - slow + 1);
            } else if (ints.size() == 1 && ints.contains(tree[i])) {
                result=Integer.max(result, i - slow + 1);
            } else if (ints.size() == 2 && ints.contains(tree[i])) {
                result=Integer.max(result, i - slow + 1);
            } else if (ints.size() == 2 && !ints.contains(tree[i])) {
                ints.add(tree[i]);
                int tar = tree[i - 1];
                for (int j = i-1; j >= 0; j--) {
                    if (tree[j] != tar) {
                        ints.remove(tree[j]);
                        slow = j+1;
                        result=Integer.max(result, i - slow);
                        break;
                    }
                }
            }
        }
        return result;
    }

}
