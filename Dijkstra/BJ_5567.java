package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_5567 {
    static int INF=(int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            list.get(a).add(new Pair(b, 1));
            list.get(b).add(new Pair(a, 1));
        }
        int d[]=new int[n+1];
        Arrays.fill(d, INF);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.offer(new Pair(1, 0));
        d[1]=0;
        while (!pq.isEmpty()){
            Pair t=pq.poll();
            int now=t.x;
            int dist=t.y;
            if(dist>d[now])continue;
            for (int i = 0; i < list.get(now).size(); i++) {
                int cost=d[now]+list.get(now).get(i).y;
                if(cost<d[list.get(now).get(i).x]){
                    d[list.get(now).get(i).x]=cost;
                    pq.offer(new Pair(list.get(now).get(i).x, cost));
                }
            }
        }
        int result=0;
        for (int i = 2; i <=n ; i++) {
            if(d[i]<=2){
                result++;
            }
        }
        System.out.println(result);
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