package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class P_8519 {
    static int v, e;
    static int[] parent =new int[101];
    static ArrayList<Edge> edges = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        for (int i = 1; i <= v ; i++) {
            parent[i]=i;
        }

        for (int i = 0; i < e; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            edges.add(new Edge(c, a, b));
        }
        Collections.sort(edges);

        int result=0;
        for (int i = 0; i < e; i++) {
            int cost = edges.get(i).distance;
            int a=edges.get(i).a;
            int b=edges.get(i).b;

            if(findParent(a)!= findParent(b)){
                unionParent(a, b);
                result+=cost;
            }
        }
        System.out.println(result);
    }
    static int findParent(int x){
        if (x==parent[x]) return x;

        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);
        if(rootA<rootB) parent[rootB] =rootA;
        else parent[rootA]=rootB;

    }

    static class Edge implements Comparable<Edge>{
        int distance;
        int a;
        int b;

        public Edge(int distance, int a, int b) {
            this.distance = distance;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance-o.distance;
        }
    }
}