package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hekai
 * @date 2025/6/21 21:36
 * @description
 * offer和 push的区别
 * offer是 queue 的方法，往队列尾部添加元素
 * push 是 stack 的方法，往栈顶增加元素
 *
 * poll 和pop的区别
 * poll() 是从队头安全取出，失败返回 null；而 pop() 是从栈顶强制弹出，失败抛异常。
 */
public class kama_99 {
    public static int count = 0;

    public static void dfs(int[][] graph,int[][] mark, int i, int j) {
        if (i < 0 || i >= graph.length ||j<0|| j >= graph[0].length || mark[i][j] != 0 || graph[i][j] == 0) {
            return;
        }
        mark[i][j] = count;
        dfs(graph,mark,i,j+1);
        dfs(graph,mark,i+1,j);
        dfs(graph,mark,i,j-1);
        dfs(graph, mark, i - 1, j);
    }
    //广搜需要使用队列
    public static void bfs(int[][] graph,int[][] mark, int startI, int startJ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startI, startJ});
        mark[startI][startJ] = count;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            for (int[] direction : directions) {
                int nowI = i + direction[0];
                int nowJ = j + direction[1];
                if (nowI >= 0 && nowI < graph.length && nowJ >= 0 && nowJ < graph[0].length && graph[nowI][nowJ] == 1 && mark[nowI][nowJ] == 0) {
                    mark[nowI][nowJ] = count;
                    queue.offer(new int[]{nowI, nowJ});
                }
            }
        }
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
                if (graph[i][j] == 1 && mark[i][j] == 0) { //没走过并且是陆地的
                    count++;
                    bfs(graph, mark, i, j);
                }
            }
        }
        System.out.println(count);
    }
}
