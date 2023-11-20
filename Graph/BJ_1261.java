package Graph;

import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_1261 {

    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n+1][m+1];
        visited=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String tmp=sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j+1]=tmp.charAt(j)-'0';
            }
        }
        bfs();

        System.out.println(map[n][m]);


    }
    static public void bfs(){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(1, 1, 0));
        visited[1][1]=1;
        int[] dx={-1, 1, 0, 0};
        int[] dy={0, 0, -1, 1};
        while (!pq.isEmpty()) {
            Pair now=pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextx=now.x+dx[i];
                int nexty=now.y+dy[i];

                if(nextx<1||nextx>n||nexty<1||nexty>m)continue;

                if(map[nextx][nexty]==0&&visited[nextx][nexty]==0){
                    pq.offer(new Pair(nextx, nexty, now.cnt));
                    visited[nextx][nexty]=1;
                    map[nextx][nexty]=now.cnt;
                }
                if(map[nextx][nexty]!=0&&visited[nextx][nexty]==0){
                    pq.offer(new Pair(nextx, nexty, now.cnt+1));
                    visited[nextx][nexty]=1;
                    map[nextx][nexty]=now.cnt+1;
                }
            }

        }
    }

    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        int cnt;
        public Pair(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cnt-o.cnt;
        }
    }
}