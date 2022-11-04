package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_2644 {
    static int n, m;
    static int user1, user2;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n= scanner.nextInt();
        user1= scanner.nextInt();
        user2 = scanner.nextInt();
        m= scanner.nextInt();
        visited = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            a= scanner.nextInt();
            b= scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bfs(user1);
        if (visited[user2]==0){
            System.out.println(-1);
        }else{
            System.out.println(visited[user2]);
        }
    }

    private static void bfs(int user1) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(user1);

        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                if(visited[graph.get(now).get(i)]==0){
                    visited[graph.get(now).get(i)]=visited[now]+1;
                    queue.offer(graph.get(now).get(i));
                }
            }
        }
    }
}