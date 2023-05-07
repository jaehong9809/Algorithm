package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1260_2 {
    static int n;
    static int m;
    static int v;
    static int matrix[][];
    static int visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        matrix = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        visited = new int[n + 1];
        dfs(v);
        System.out.println();
        visited = new int[n + 1];
        bfs();

    }

    private static void dfs(int start) {
        if (visited[start] == 0) {
            visited[start] = 1;
            System.out.print(start+" ");
        }
        for (int i = 1; i <= n; i++) {
            if (matrix[start][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v]=1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now+" ");

            for (int i = 1; i <= n; i++) {
                if (matrix[now][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }
}