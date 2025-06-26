package Graph;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hekai
 * @date 2025/6/26 20:45
 * @description TODO
 */
public class kama_102 {

    public static void main(String[] args) {
        String testInput1 =
                "10 10\n" +
                        "1 0 1 0 1 1 0 1 0 0\n" +
                        "1 1 1 0 1 1 0 0 1 0\n" +
                        "0 0 0 0 1 0 1 0 1 0\n" +
                        "0 1 0 0 1 1 0 1 1 0\n" +
                        "1 0 1 0 0 1 1 0 0 0\n" +
                        "1 0 0 1 0 0 0 1 0 1\n" +
                        "1 0 0 1 0 0 0 0 0 1\n" +
                        "0 1 0 1 0 0 0 1 1 1\n" +
                        "1 1 1 0 0 1 0 1 1 0\n" +
                        "1 1 0 1 0 0 1 1 0 1\n";
        String testInput =
                "4 5\n" +
                "1 1 0 0 0\n" +
                "1 1 0 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 1 1\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8)));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        int[][] mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
//            bfs(graph, mark, i, 0);
            dfs(graph, mark, i, 0);
//            bfs(graph, mark, i, m - 1);
            dfs(graph, mark, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
//            bfs(graph, mark, 0, i);
            dfs(graph, mark, 0, i);
//            bfs(graph, mark, n - 1, i);
            dfs(graph, mark, n - 1, i);
        }
        for (int[] ints : mark) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int[][] graph, int[][] mark, int i, int j) {
        if (i < 0 || j < 0 || i > graph.length - 1 || j > graph[0].length - 1 || mark[i][j] == 1 || graph[i][j] == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        queue.offer(new int[]{i, j});
        mark[i][j] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int oldi = poll[0];
            int oldj = poll[1];
            for (int[] di : directions) {
                int nowI = oldi + di[0];
                int nowJ = oldj + di[1];
                if (nowI >= 0 && nowI <= graph.length - 1 && nowJ >= 0 && nowJ <= graph[0].length - 1
                        && graph[nowI][nowJ] == 1 && mark[nowI][nowJ] == 0) {
                    mark[nowI][nowJ] = 1;
                    queue.offer(new int[]{nowI, nowJ});
                }
            }
        }
    }

    private static void dfs(int[][] graph, int[][] mark, int i, int j) {
        if (i >= 0 && i <= graph.length - 1 && j >= 0 && j <= graph[0].length - 1 && graph[i][j] == 1 && mark[i][j] == 0) {
            mark[i][j] = 1;
            dfs(graph, mark, i + 1, j);
            dfs(graph, mark, i, j + 1);
            dfs(graph, mark, i - 1, j);
            dfs(graph, mark, i, j - 1);
        }
    }

}
