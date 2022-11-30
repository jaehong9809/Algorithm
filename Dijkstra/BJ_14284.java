package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BJ_14284 {
    static int INF=(int )1e9;
    static int n, m, t;
    static int distance[];
    static ArrayList<ArrayList<Pair>> data= new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        distance=new int[n+1];
        Arrays.fill(distance, INF);
        for (int i = 0; i <= n; i++) {
            data.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            data.get(b).add(new Pair(a, c));
            data.get(a).add(new Pair(b, c));
        }
        st=new StringTokenizer(br.readLine());
        int s= Integer.parseInt(st.nextToken());
        t= Integer.parseInt(st.nextToken());
        dijkstra(s);
        System.out.println(distance[t]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        distance[start]=0;
        while (!pq.isEmpty()) {
            Pair tmp=pq.poll();
            int now=tmp.x;
            int dist=tmp.y;
            if (distance[now]<dist)continue;

            for (int i = 0; i < data.get(now).size(); i++) {
                int cost=distance[now]+data.get(now).get(i).y;
                if(distance[data.get(now).get(i).x]>cost){
                    distance[data.get(now).get(i).x]=cost;
                    pq.offer(new Pair(data.get(now).get(i).x, cost));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.y-o.y;
        }
    }
}