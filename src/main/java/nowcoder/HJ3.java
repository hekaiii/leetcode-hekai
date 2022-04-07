package nowcoder;

import java.util.*;

/**
 * @Date: 2022/4/7 23:04
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
//        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> integers1 = new TreeSet<>();
        for (int j = 0; j < i; j++) {
            integers1.add(scanner.nextInt());
        }
        int[] ints = new int[integers1.size()];
        int index = 0;
        for (Integer integer : integers1) {
            ints[index++] = integer;
        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
