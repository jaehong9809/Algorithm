package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_24480 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> data = new ArrayList<>();
    static int[] visited;
    static int cnt=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        r=sc.nextInt();
        visited=new int[n+1];
        for (int i = 0; i <= n; i++) {
            data.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            data.get(a).add(b);
            data.get(b).add(a);
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(data.get(i), Collections.reverseOrder());
        }
        dfs(r);
        for (int i = 1; i <=n ; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int start){
        if(visited[start]==0){
            visited[start]=cnt++;
        }

        for (int i = 0; i < data.get(start).size(); i++) {
            int next = data.get(start).get(i);

            if(visited[next]==0){
                dfs(next);
            }
        }
    }
}