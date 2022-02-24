package Array;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/22 21:22
 */
public class leetcode_3 {
    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(res);


    }
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        if (str.length == 0) {
            return 0;
        }
        for (int end = 0; end < str.length; end++) {
            if (map.containsKey(str[end])) {
                start = start>map.get(str[end])?start:map.get(str[end]);
            }
            map.put(str[end], end+1);
            int nowresult = end + 1 - start;
            result = result < nowresult ? nowresult : result;
        }
        return result;
    }
}
