package test;

import java.util.LinkedList;

/**
 * @Date: 2022/5/5 17:13
 */
public class test05 {

    public static void dfs(Graph graph, int start, boolean[] visited) {
        System.out.println(graph.vertexts[start].data);
        visited[start] = true;
        for (int index : graph.adj[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    public static void bfs(Graph graph, int start, boolean[] visited, LinkedList<Integer> queue) {
        queue.offer(start);
        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (visited[front]) {
                continue;
            }
            System.out.println(graph.vertexts[front].data);
            visited[front] = true;
            for (int index : graph.adj[front]) {
                queue.offer(index);
            }
        }
    }

    private static class Vertext {
        int data;

        public Vertext(int data) {
            this.data = data;
        }
    }

    private static class Graph {
        private int size;
        private Vertext[] vertexts;
        private LinkedList<Integer>[] adj;

        public Graph(int size) {
            this.size = size;
            vertexts = new Vertext[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertexts[i] = new Vertext(i);
                adj[i] = new LinkedList();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);
        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);
        graph.adj[2].add(0);
        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);
        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);
        graph.adj[5].add(3);
        graph.adj[5].add(4);
        System.out.println("dfs: ");
        dfs(graph, 0, new boolean[graph.size]);
        System.out.println("bfs: ");
        bfs(graph, 0, new boolean[graph.size], new LinkedList<Integer>());
    }

}
