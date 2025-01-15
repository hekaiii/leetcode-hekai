package String;

import java.util.Scanner;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/10/16
 */
public class kama_55 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int index = sc.nextInt();
    String s = sc.next();
    System.out.println((s+s).substring(s.length()-index,s.length()*2-index));
    char[] charArray = s.toCharArray();
    char[] result = new char[charArray.length];
    int start = 0;
    for (int i = charArray.length - index; i < charArray.length; i++) {
      result[start] = charArray[i];
      start++;
    }
    for (int i = 0; i < charArray.length - index; i++) {
        result[start] = charArray[i];
        start++;
    }
    System.out.println(new String(result));


  }
}
