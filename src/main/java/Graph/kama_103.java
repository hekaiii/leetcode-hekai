package Graph;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * @author hekai
 * @date 2025/7/1 20:47
 * @description TODO
 *
 *   1 3 1 2 4
 *   1 2 1 3 2
 *   2 4 7 2 1
 *   4 5 6 1 1
 *   1 4 1 2 1
 */
public class kama_103 {
    static ArrayList<int[]> result = new ArrayList<>();
    public static void main(String[] args) {
        String str =
                "5 5\n" +
               "1 3 1 2 4\n" +
               "1 2 1 3 2\n" +
               "2 4 7 2 1\n" +
               "4 5 6 1 1\n" +
               "1 4 1 2 1\n" ;
        System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        int[][] first = new int[n][m];
        int[][] second = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(graph, first, i, 0);//左侧第一边界
            dfs(graph, second, i, m - 1);//右侧第二边界
        }
        for (int i = 0; i < m; i++) {
            dfs(graph, first, 0, i);//上第一边界
            dfs(graph, second, n-1, i);//下第二边界
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (first[i][j] == second[i][j] && first[i][j] != 0) {
                    result.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : result) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
    //广 用queue
    private static void bfs(int[][] graph, int[][] marked, int i, int j) {

    }
    //深 递归三部曲
    private static void dfs(int[][] graph, int[][] marked, int i, int j) {
        HashMap<Object, Object> map = new HashMap<>();
        if (marked[i][j] == 1) {
            return;
        }
        marked[i][j] = 1;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] ints : direction) {
            int nowI = i + ints[0];
            int nowJ = j + ints[1];
            if (nowI >= 0 && nowJ >= 0 && nowI < graph.length && nowJ < graph[0].length) {
                if (graph[nowI][nowJ] > graph[i][j]) {
                    dfs(graph, marked, nowI, nowJ);
                }
            }
        }
    }
}
