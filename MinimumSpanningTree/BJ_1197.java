package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_1197 {
    static int v, e;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(edges);
        long result = 0;
        for (Edge edge : edges) {
            if (findParent(edge.a) != findParent(edge.b)) {
                unionParent(edge.a, edge.b);
                result += edge.distance;
            }
        }
        System.out.println(result);
    }

    static int findParent(int x) {
        if (parent[x] == x) return x;

        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        int roota = findParent(a);
        int rootb = findParent(b);
        if (roota < rootb) parent[rootb] = roota;
        else parent[roota] = rootb;
    }


    static class Edge implements Comparable<Edge> {
        int distance;
        int a;
        int b;

        public Edge(int a, int b, int distance) {
            this.distance = distance;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}