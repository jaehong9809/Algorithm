package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_1753_2 {
    static int v, e;
    static int INF=(int)1e9;
    static int startNode;
    static ArrayList<ArrayList<Pair>> data = new ArrayList<>();
    static int d[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        startNode=sc.nextInt();
        d=new int[v+1];
        Arrays.fill(d, INF);
        for (int i = 0; i < v+1; i++) {
            data.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a, b, w;
            a=sc.nextInt();
            b=sc.nextInt();
            w=sc.nextInt();
            data.get(a).add(new Pair(b, w));
            }
        dijkstra();
        for (int i = 1; i <=v ; i++) {
            if(d[i]==INF) System.out.println("INF");
            else{
                System.out.println(d[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Pair(startNode, 0));
        d[startNode]=0;
        while (!priorityQueue.isEmpty()){
            Pair now= priorityQueue.poll();
            int cost=now.y;
            int node=now.x;
            if(cost>d[node])continue;
            for (int i = 0; i < data.get(node).size(); i++) {
                int dist=d[node]+data.get(node).get(i).y;
                if(dist<d[data.get(node).get(i).x]){
                    priorityQueue.offer(new Pair(data.get(node).get(i).x, dist));
                    d[data.get(node).get(i).x]=dist;
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
            if (this.y < o.y) {
                return -1;
            }
            return 1;
        }
    }
}