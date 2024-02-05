package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1303 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int me = 0;
    static int you = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        map = new char[n][m];
        visited = new boolean[n][m];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(me + " " + you);
    }

    public static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        char nowP = map[sx][sy];

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (!(nx >= 0 && nx < n && ny >= 0 && ny < m)) continue;

                if (!visited[nx][ny] && map[nx][ny] == nowP) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if (nowP == 'W') {
            me += Math.pow(cnt, 2);
        } else {
            you += Math.pow(cnt, 2);
        }
    }
}