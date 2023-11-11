package Graph;

import java.util.*;

class BJ_24445 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i <= n; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        bfs();
        for (int i = 1; i <= n ; i++) {
            System.out.println(visited[i]);
        }
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        visited[r]=1;
        int cnt=1;
        while (!queue.isEmpty()) {
            int now=queue.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next=graph.get(now).get(i);
                if(visited[next]==0){
                    cnt++;
                    visited[next]=cnt;
                    queue.offer(next);
                }

            }
        }
    }
}