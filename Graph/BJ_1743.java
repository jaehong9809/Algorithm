package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1743 {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int max=-1;
    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        map=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0; i<k; i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            map[a][b]=1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]==1){
                    max=Math.max(bfs(i, j), max);
                }
            }
        }
        System.out.println(max);
    }

    public static int bfs(int startx, int starty){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx, starty});
        int cnt=0;
        visited[startx][starty]=true;
        while (!q.isEmpty()){
            int[] poll = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx=dx[i]+poll[0];
                int ny=dy[i]+poll[1];
                if(!(nx>=0&&nx<n&&ny>=0&&ny<m)) continue;
                if(!visited[nx][ny]&&map[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
}