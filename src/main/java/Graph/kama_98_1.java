package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hekai
 * @date 2025/6/18 08:11
 * @description TODO
 */
public class kama_98_1 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    private static void dfs(List<LinkedList<Integer>> graph, int start, int end) {
        if (start == end) {
            result.add(new ArrayList<>(path));
            return;
        }
        LinkedList<Integer> ints = graph.get(start);
        for (Integer anInt : ints) {
            path.add(anInt);
            dfs(graph,anInt,end);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //第二种方法 邻接表
        List<LinkedList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        while (m-- > 0) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            graph.get(s).add(t);
        }
        path.add(1);
        dfs(graph, 1, n);
        for (List<Integer> integers : result) {
            for (int i = 0; i < integers.size(); i++) {
                if (i == integers.size() - 1) {
                    System.out.println(integers.get(i));
                } else {
                    System.out.print(integers.get(i)+" ");
                }
            }
        }
    }
}
