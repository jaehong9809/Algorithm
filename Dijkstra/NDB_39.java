package Dijkstra;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
 */
class NDB_39 {
    static int INF= (int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int n= sc.nextInt();
            int matrix[][]=new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j]= sc.nextInt();
                }
            }
            dijkstra(0, 0, matrix, n);
        }

    }

    private static void dijkstra(int startx, int starty, int[][]matrix, int n) {
        PriorityQueue<Pair> queue=new PriorityQueue<>();
        int d[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j]=INF;
            }
        }
        queue.offer(new Pair(startx, starty, 0));
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        d[startx][starty]=matrix[0][0];
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if(d[now.x][now.y]<now.value)continue;
            for (int i = 0; i < 4; i++) {
                int newx = dx[i] + now.x;
                int newy = dy[i] + now.y;
                if(newx>=0&&newx<n&&newy>=0&&newy<n){
                    int cost=d[now.x][now.y]+matrix[newx][newy];
                    if(cost<d[newx][newy]){
                        d[newx][newy]=cost;
                        queue.offer(new Pair(newx, newy, cost));
                    }
                }
            }

        }
        System.out.println(d[n-1][n-1]);
    }
    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        public int value;
        public Pair(int x, int y, int value){
            this.x=x;
            this.y=y;
            this.value=value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value-o.value;
        }
    }
}