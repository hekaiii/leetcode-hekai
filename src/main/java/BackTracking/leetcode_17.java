package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/30
 */
public class leetcode_17 {

  ArrayList result = new ArrayList<String>();
  ArrayList list = new ArrayList<Character>();
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0 || digits.length() > 4) {
      return result;
    }
    String[] nums = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    char[] charArray = digits.toCharArray();
    getResult(nums,charArray,digits,0);
    return result;
  }

  private void getResult(String[] nums, char[] chars, String digits, int startIndex) {
    if (list.size() == digits.length()) {
      result.add(list.stream().map(String::valueOf).collect(Collectors.joining()));
      return;
    }
    char[] array = nums[chars[startIndex] - '2'].toCharArray();
    for (char c : array) {
      list.add(c);
      getResult(nums, chars, digits, startIndex + 1);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
//    List<String> result = letterCombinations("23");
//    System.out.println(result);
  }
}
