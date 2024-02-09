package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class BJ_21736 {
    static int n;
    static int m;
    static char[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph = new char[n][m];
        visited=new boolean[n][m];
        sc.nextLine();

        int sx=-1;
        int sy=-1;
        for (int i = 0; i <n ; i++) {
            String str=sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j]=str.charAt(j);
                if(graph[i][j]=='I'){
                    sx=i;
                    sy=j;
                }
            }
        }
        int result = bfs(sx, sy);
        if(result!=0) System.out.println(result);
        else System.out.println("TT");
    }

    private static int bfs(int sx, int sy) {
        int cnt=0;
        Queue<int[]> q=new LinkedList<>();
        int[] dx={-1, 1, 0, 0};
        int[] dy={0, 0, -1, 1};
        q.offer(new int[]{sx, sy});
        visited[sx][sy]=true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            if(graph[now[0]][now[1]]=='P'){
                cnt++;
            }
            for (int i = 0; i < 4; i++) {
                int nx=dx[i]+now[0];
                int ny=dy[i]+now[1];
                if(nx<0||nx>=n||ny<0||ny>=m) continue;

                if(!visited[nx][ny]&& graph[nx][ny]!='X'){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
}