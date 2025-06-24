package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hekai
 * @date 2025/6/22 22:09
 * @description TODO
 * 分别使用广搜和深搜完成
 */
public class kama_100 {
    private static int result = 0;
    //广搜用队列
    private static int bfs(int[][] graph, int[][] mark, int i, int j) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        mark[i][j] = 1;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            for (int[] direction : directions) {
                int nowI = a + direction[0];
                int nowJ = b + direction[1];
                if (nowI >= 0 && nowI < graph.length && nowJ >= 0 && nowJ < graph[0].length && graph[nowI][nowJ] == 1 && mark[nowI][nowJ] == 0) {
                    mark[nowI][nowJ] = 1;
                    area++;
                    queue.offer(new int[]{nowI, nowJ});
                }
            }
        }
        return area;
    }

    private static int dfs(int[][] graph, int[][] mark, int i, int j) {
        if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || graph[i][j] != 1 || mark[i][j] == 1) {
            return 0;
        }
        mark[i][j] = 1;
        int area = 1;
        area += dfs(graph, mark, i + 1, j);
        area += dfs(graph, mark, i - 1, j);
        area += dfs(graph, mark, i, j + 1);
        area += dfs(graph, mark, i, j - 1);
        return area;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int[][] mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && mark[i][j] == 0) {
//                    result = Math.max(bfs(graph, mark, i, j), result);
                    result = Math.max(dfs(graph, mark, i, j), result);
                }
            }
        }
        System.out.println(result);
    }


}
