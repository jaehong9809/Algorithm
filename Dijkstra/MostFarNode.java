package Dijkstra;

import java.util.*;

class MostFarNode {
    static int INF = (int) 1e9;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int[][] edge2={{1,3 },{1,2},{2,3}, {2,4}, {3,4}};
        System.out.println(solution(4, edge2));
    }

    static public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] d = new int[n + 1];

        Arrays.fill(d, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(new Node(edge[i][1], 1));
            graph.get(edge[i][1]).add(new Node(edge[i][0], 1));
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d : ", i);
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.printf("%d(%d) ", graph.get(i).get(j).y, graph.get(i).get(j).w);
            }
            System.out.println();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        d[1] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.y;
            int cost = node.w;
            System.out.printf("%d : 가중치(%d) \n", now, cost);

            if (d[now] < cost) {
                continue;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int dist = d[now] + graph.get(now).get(i).w;
                if (d[graph.get(now).get(i).y] > dist) {
                    d[graph.get(now).get(i).y] = dist;
                    System.out.printf("%d에 %d 저장\n", graph.get(now).get(i).y, dist);
                    pq.offer(new Node(graph.get(now).get(i).y, dist));


                }

            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", d[i]);
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            results.add(d[i]);
        }
        int max = Collections.max(results);
        for (Integer i : results) {
            if (i == max) answer++;
        }
        return answer;
    }

    static public class Node implements Comparable<Node> {
        int y;
        int w;

        public Node(int y, int w) {
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}