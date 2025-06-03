package String;

/**
 * @Author: hekai
 * @Description:
 * KMP算法主要分为两步，第一步计算出模板串的LPS数组，第二步用模板串+LPS数组去和给出数组进行比较
 * 难点一：LPS数组
 *      这个数组是计算模板串“最长相同前后缀的” 例如 aa这个串 前缀是a 后缀是a 所以aa的LPS是[0,1]
 *      a 这个数组串是[0] 因为前缀不能包含最后一个字母，后缀不能包含第一个字母所以，这个a这种极端情况为0，即所有一个字母的串 LPS数组都是0
 *      ABABAC
 *      001230
 *      A和B比，不等，A和A比，相等了，各自前进一位A和A比
 *      A1 LPS初始值为0
 *      B1跟A1不等，所以B1也是0
 *      A1和A2等了，由于LPS记录的值是“最长相等前后缀” 前缀：A AB 后缀：BA A 最长为1所以记录的值为1
 *      重要！！！ 1这个时候在代码中表现为 index++ lps[i]=index
 *                为什么现index++再给lps赋值呢，其实是因为数组的指针是从1开始的，但是LPS数据中的值表达的是这个子串中最长前后缀的长度
 *                比如AA，A2等于A1，此时A1等于0，这两个是相等了，但是他们的长度是1而不是index(0)，所以你得给index+1
 *      但发现不同的时候也有说法：1)发现不同了，但是index=0，说明当前i遍历的这个元素和第一个元素就不同，那肯定没法继续往下比较了，
 *                              所以这个位置result[i]=0
 *                           2)发现了不同，但是index!=0,说明现在在比较前后缀的过程中，前缀和后缀有相同，但是现在出现了第一个不同，即出现了分歧
 *                              这个时候，LPS数组就要进行回溯了。回溯的目的是为了降低时空复杂度，看看已经跑了这么多的前缀中，有没有保存点，有的话就从保存点开始继续比较
 *                              如果没有保存点，那么就没办法了，只能从0开始。
 *                              a)何为“保存点”？
 *                              例如ABABAC这个字符串，当比较到C的时候，index子串最长前缀是ABAB i子串的最长前缀是ABAC
 *                                 001230
 *                                 ABAB vs ABAC 前三个相同，第四个不同，所以C的lps位置不可能等于4了，但是从0开始又太蠢了
 *                                 所以现在回溯，找找能不能退而求其次，获得一个小于4的长度，但是呢又要满足上一个字母也是C前面的字母，即A，
 *                                 变成了比较A2上一次出现的位置。因为A2B2不等于A2C1，所以要找上一次A出现的位置的下一个字母能不能和C1匹配上
 *                                 由于ABAB这里的B2不等了，B2前面是A2，就找A2有没有最长前后缀，A2对应1，
 *                                 说明从第一个元素到A2组成的ABA，是一个最长公共前后缀为1的字串，1对应的坐标，其实和B2对应的坐标是相同的，因为前一个都是A
 *                                 死记硬背：ABAB ABAC = ABA + C，中间的B ABA去掉，开始比较ABAC这个串中C的值，index=B i=C开始比较。
 *
 * @Date: 2024/10/16
 */
public class leetcode_28 {

  public static int[] buildLPS(String pattern) {
    int[] result = new int[pattern.length()];
    int j = 0;
    for (int i = 1; i < pattern.length(); i++) {
      while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
        j = result[j - 1];
      }
      if (pattern.charAt(j) == pattern.charAt(i)) {
        j++;
      }
      result[i] = j;
    }
    return result;
  }
  // KMP 字符串匹配
  public static int KMP_Search(String haystack, String needle) {
    if (needle.isEmpty()) return 0;

    int m = haystack.length();
    int n = needle.length();

    int[] lps = buildLPS(needle);  // 生成 LPS 表
    int i = 0, j = 0;

    while (i < m) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      }
      if (j == n) {
        return i - j;  // 找到匹配
      } else if (i < m && haystack.charAt(i) != needle.charAt(j)) {
        if (j != 0) {
          j = lps[j - 1];  // 跳过重复匹配
        } else {
          i++;
        }
      }
    }
    return -1;  // 没有匹配到
  }
  public static int[] LPS(String needle) {
    int[] lps = new int[needle.length()];
    int length = 0;
    int i = 1;

    while (i < needle.length()) {
      if (needle.charAt(i) == needle.charAt(length)) {
        length++;
        lps[i] = length;
        i++;
      } else {
        if (length != 0) {
          length = lps[length - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }
  public static int strStr(String haystack, String needle){
    int result = -1;
    int[] lps = buildLPS(needle);
    int j = 0;
    for (int i = 0; i < haystack.length(); i++) {
      while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
        j = lps[i - 1];
      }
      if (haystack.charAt(i) == needle.charAt(j)) {
        j++;
      }
      if (j == needle.length()) {
        result = i - needle.length() + 1;
        break;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    String haystack ="asadbutsad";
    String needle ="aaabaaabaaaac";
    int[] ints = buildLPS(needle);
    for (int anInt : ints) {
      System.out.print(anInt+" ");
    }
//    System.out.println(strStr(haystack, needle));
  }

}
