package nowcoder;


import java.util.Scanner;

/**
 * @Date: 2022/4/7 21:36
 */
public class HJ17 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split(";");
        for (String s : split) {
            if (s.length() < 2) {
                continue;
            }
            if ((s.charAt(0) != 'A') && (s.charAt(0) != 'S') && (s.charAt(0) != 'D') && (s.charAt(0) != 'W')) {
                continue;
            }
            if (s.length() == 2) {
                if (!Character.isDigit(s.charAt(1))) {
                    continue;
                }
            } else if (Character.isLetter(s.charAt(1)) || Character.isLetter(s.charAt(2))) {
                continue;
            }
            if ((s.charAt(0) == 'A') && (Integer.valueOf(s.substring(1)) <= 10000) && (Integer.valueOf(s.substring(1)) >= 1)) {
                x -= Integer.valueOf(s.substring(1));
            } else if ((s.charAt(0) == 'D') && (Integer.valueOf(s.substring(1)) <= 10000) && (Integer.valueOf(s.substring(1)) >= 1)) {
                x += Integer.valueOf(s.substring(1));
            } else if ((s.charAt(0) == 'S') && (Integer.valueOf(s.substring(1)) <= 10000) && (Integer.valueOf(s.substring(1)) >= 1)) {
                y -= Integer.valueOf(s.substring(1));
            } else if ((s.charAt(0) == 'W') && (Integer.valueOf(s.substring(1)) <= 10000) && (Integer.valueOf(s.substring(1)) >= 1)) {
                y += Integer.valueOf(s.substring(1));
            }
        }
        System.out.print(x + "," + y);
    }
}
