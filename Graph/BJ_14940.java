package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BJ_14940 {
    static int n;
    static int m;
    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];
        int startx = 0;
        int starty = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
            }
        }
        bfs(startx, starty);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]&&matrix[i][j]==1){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void bfs(int startx, int starty) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx, starty});
        matrix[startx][starty] = 0;
        visited[startx][starty] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (!(nx >= 0 && nx < n && ny >= 0 && ny < m)) continue;

                if (!visited[nx][ny] && matrix[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    matrix[nx][ny] = matrix[now[0]][now[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

}