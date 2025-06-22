package Graph;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author hekai
 * @date 2025/6/7 00:34
 * @description TODO
 */
public class kama_98 {
    static List<List<Integer>> result = new ArrayList<>();
    static List path = new ArrayList();

    private static void dfs(int[][] graph, int cur, int n) {
        if (cur == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (graph[cur][i] == 1) {
                path.add(i);
                dfs(graph, i, n);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //两种解法 邻接矩阵 邻接表
        int[][] graph = new int[n + 1][n + 1];
        while (m-->0) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            graph[s][t] = 1;
        }
        path.add(1);
        dfs(graph, 1, n);

        //第二种方法
        

        if (result.isEmpty()) {
            System.out.println(-1);
        }
        for (List<Integer> integers : result) {
            for (int i = 0; i < integers.size() - 1; i++) {
                System.out.print(integers.get(i) + " ");
            }
            System.out.println(integers.get(integers.size() - 1));
        }
    }

}
