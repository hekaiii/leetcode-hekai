package Array;

import org.openjdk.jol.vm.VM;

public class test01 {
    public static void main(String[] args) {
        int [][] a1 = {{1,2,3},{3,4,5},{5,6,7},{7,8,9}};
        int[] a2 = {1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(VM.current().addressOf(a1[i][j]));
            }
        }
        int a = 3;
        System.out.println(VM.current().addressOf(a));
    }
}
