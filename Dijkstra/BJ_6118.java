package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_6118 {
    static int[] d;
    static int INF=(int)1e9;
    static ArrayList<ArrayList<Pair>> data = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        d=new int[n+1];
        Arrays.fill(d, INF);
        for (int i = 0; i <=n; i++) {
            data.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            data.get(a).add(new Pair(b, 1));
            data.get(b).add(new Pair(a, 1));
        }
        dijkstra(1);
        int number=0;
        int result=-1;
        for (int i = 1; i <= n; i++) {
            if(d[i]!=INF){
                if(result<d[i]){
                    number=i;
                    result=d[i];
                }
            }
        }
        int cnt=0;
        for (int i = 1; i <=n ; i++) {
            if(result==d[i])cnt++;
        }
        System.out.println(number+" " +result+" "+cnt);
    }

    public static void dijkstra(int startx){
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>();
        pairPriorityQueue.offer(new Pair(startx, 0));
        d[startx]=0;

        while (!pairPriorityQueue.isEmpty()) {
            Pair tmp= pairPriorityQueue.poll();
            int now=tmp.x;
            int dist=tmp.y;
            if(d[now]<dist)continue;
            for (int i = 0; i < data.get(now).size(); i++) {
                int cost=d[now]+data.get(now).get(i).y;
                if(d[data.get(now).get(i).x]>cost){
                    d[data.get(now).get(i).x]=cost;
                    pairPriorityQueue.offer(new Pair(data.get(now).get(i).x, cost));
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