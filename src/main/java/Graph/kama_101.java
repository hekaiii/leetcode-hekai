package Graph;

import javax.sound.sampled.Line;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hekai
 * @date 2025/6/23 22:39
 * @description TODO
 */
public class kama_101 {
    private static int result = 0;

    public static void main(String[] args) {
        String testInput =
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
        System.setIn(new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8)));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] graph = new int[n][m];
        int[][] mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m - 1; j++) {
//                dfs(graph, mark, i, j);
                if (graph[i][j] == 1 && mark[i][j] == 0) {
                    int area = bfs(graph, mark, i, j);
                    result += area;
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int[][] graph, int[][] mark, int i, int j) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        mark[i][j] = 1;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i1 = poll[0];
            int i2 = poll[1];
            for (int[] dir : directions) {
                int nowI = i1 + dir[0];
                int nowJ = i2 + dir[1];
                if (nowI > 0 && nowI < graph.length-1
                        && nowJ > 0 && nowJ < graph[0].length-1
                        && graph[nowI][nowJ] == 1
                        && mark[nowI][nowJ] == 0) {
                    mark[nowI][nowJ] = 1;
                    area++;
                    queue.offer(new int[]{nowI, nowJ});
                } else if (graph[nowI][nowJ] == 1 && (nowI == 0 || nowJ == 0 || nowI == graph.length - 1 || nowJ == graph[0].length-1)) {
                    mark[nowI][nowJ] = 1;
                    //不应该简单粗暴的直接返回0，即便找到碰壁的岛，也应该将其每一个土地都遍历完并标记
                    return 0;
                }
            }
        }
        return area;
    }

    private static void dfs(int[][] graph, int[][] mark, int i, int j) {
    }
}
