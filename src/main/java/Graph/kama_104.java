package Graph;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author hekai
 * @date 2025/8/24 20:07
 * @description 建造最大岛屿
 */
public class kama_104 {
    private static int count = 0;
    private static int result = 0;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        String str =
                "4 5\n" +
                        "1 1 0 0 0\n" +
                        "1 1 0 0 0\n" +
                        "0 0 1 0 0\n" +
                        "0 0 0 1 1\n";
        System.setIn(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        int[][] visited = new int[n][m];
        int mark = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    count=0;
                    dfs(graph, visited, i, j, mark);
                    map.put(mark, count);
                    mark++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                HashSet<Integer> set = new HashSet<>();
                if (graph[i][j] == 0) {
                    int newResult = 1;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                            continue;
                        }
                        int curMark = graph[ni][nj];
                        if (set.contains(curMark) || !map.containsKey(curMark)) {
                            continue;
                        }
                        set.add(curMark);
                        newResult += map.get(curMark);
                    }
                    result = Math.max(result,newResult);
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int[][] graph, int[][] visited, int i, int j, int mark) {
        if (visited[i][j] == 1 || graph[i][j] == 0) {
            return;
        }
        visited[i][j] = 1;
        graph[i][j] = mark;
        count++;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextJ < 0 || nextI < 0 || nextI >= graph.length || nextJ >= graph[0].length) {
                continue;
            } else {
                dfs(graph, visited, nextI, nextJ, mark);
            }
        }
    }

}
