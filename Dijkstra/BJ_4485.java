package Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_4485 {
    static int INF=(int)1e9;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int TESTCASE=1;
        while (true){
            n=sc.nextInt();
            if(n==0)break;


            int[][] matrix=new int[n][n];
            int[][] d=new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=sc.nextInt();
                }
            }
            d[0][0]=matrix[0][0];
            int result=0;

           dijkstra(matrix, d, n);
            result = d[n - 1][n - 1];
            System.out.println("Problem "+TESTCASE+": "+result);

           /* for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(d[i][j]+" ");
                }
                System.out.println();
            }*/
            TESTCASE++;
        }

    }
    public static int[][] dijkstra(int[][] matrix, int[][] d, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0,matrix[0][0]));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cost=now.w;
            int x=now.x;
            int y=now.y;
            if(cost>d[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nextx=dx[i]+x;
                int nexty=dy[i]+y;
                if(nextx<0||nextx>=n||nexty<0||nexty>=n)continue;

                int dist = cost + matrix[nextx][nexty];
                if(dist<d[nextx][nexty]){
                    d[nextx][nexty]=dist;
                    pq.offer(new Node(nextx, nexty, dist));
                }
            }
        }
        return d;
    }
    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
}