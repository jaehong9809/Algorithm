package Dijkstra;

import java.util.*;

class Solution_mostfarnode {
    static int INF = (int) 1_000_000_000;
    static Integer[] d;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;

        d = new Integer[n + 1];
        Arrays.fill(d, INF);


        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dijkstra(1);
        for (int i = 0; i < d.length; i++) {
            if (d[i] == INF) {
                d[i] = 0;
            }
        }
        List<Integer> list = Arrays.asList(d);

        answer = Collections.frequency(list, Collections.max(list));


        return answer;
    }

    public void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int nowNode = poll.node;
            int cost = poll.weight;

            if (d[nowNode] > cost) {
                continue;
            }

            for (int i = 0; i < graph.get(nowNode).size(); i++) {
                int nextNode = graph.get(nowNode).get(i);
                if (d[nextNode] > d[nowNode] + 1) {
                    pq.offer(new Pair(nextNode, d[nowNode] + 1));
                    d[nextNode] = d[nowNode] + 1;
                }
            }


        }
    }

    static class Pair implements Comparable<Pair> {
        public int node;
        public int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
}