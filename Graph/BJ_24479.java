package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_24479 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] order;
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        r=sc.nextInt();
        visited = new boolean[n + 1];
        order = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <=n ; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(r);
        for (int i = 1; i <=n ; i++) {
            System.out.println(order[i]);
        }

    }

    private static void dfs(int start) {
        if(!visited[start]){
            order[start]=++cnt;
            visited[start]=true;
        }

        for (int i = 0; i <graph.get(start).size() ; i++) {
            if(!visited[graph.get(start).get(i)]){
                dfs(graph.get(start).get(i));
            }
        }
    }
}