package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BJ_1753 {
    static class Pair implements Comparable<Pair> {
        public int end;
        public int weight;

        public Pair(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight-o.weight;
        }
    }
    static ArrayList<ArrayList<Pair>> graph=new ArrayList<>();
    static final int INF= (int) 1e9;
    static int d[];
    static int v, e, start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i <=v; i++) {
            graph.add(new ArrayList<>());
        }
        d = new int[v + 1];
        Arrays.fill(d, INF);
        start = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            int a, b, c;
            s=br.readLine();
            st=new StringTokenizer(s);
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            graph.get(a).add(new Pair(b, c));
        }
        dijkstra(start);
        for (int i = 1; i <= v; i++) {
            if (d[i]==INF){
                System.out.print("INF ");
            }
            else System.out.println(d[i]+" ");
        }
    }
    public static void dijkstra(int startNode) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(startNode, 0));
        d[startNode]=0;
        while (!pq.isEmpty()){
            Pair pair=pq.poll();
            int next=pair.end;
            int cost=pair.weight;
            if(d[next]<cost)continue;
            for (int i = 0; i < graph.get(next).size(); i++) {
                int dist=d[next]+graph.get(next).get(i).weight;
                if(dist<d[graph.get(next).get(i).end]){
                    d[graph.get(next).get(i).end]=dist;
                    pq.add(new Pair(graph.get(next).get(i).end, dist));
                }
            }
        }
    }

}