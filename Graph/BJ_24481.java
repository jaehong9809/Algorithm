package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_24481 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] depth;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        r=sc.nextInt();
        depth=new int[n+1];
        for (int i = 0; i <= n ; i++) {
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
        depth[r]=-1;
        dfs(r, 0);
        for (int i = 1; i <=n ; i++) {
            if(i==r){
                System.out.println(0);
                continue;
            }
            if(depth[i]==0){
                System.out.println(-1);
                continue;
            }
            System.out.println(depth[i]);
        }
    }

    private static void dfs(int r, int cnt) {

        if(depth[r]==0){
            depth[r]=cnt;
        }

        for (int i = 0; i < graph.get(r).size(); i++) {
            int next=graph.get(r).get(i);
            if(depth[next]==0){
                dfs(next, cnt+1);
            }
        }

    }
}