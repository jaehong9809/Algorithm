package ToDo;

import java.util.Scanner;

class BJ_14500 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] arr;
    static int max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        arr = new int[4][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[0][0] = i;
                arr[0][1] = j;
                visited[i][j] = true;
                dfs(1, i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    public static void dfs(int depth, int x, int y) {
        if (depth == 4) {
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                cnt += map[arr[i][0]][arr[i][1]];

            }
            if (max < cnt) {
                max = cnt;
//                for (int i = 0; i < 4; i++) {
//                    System.out.print(map[arr[i][0]][arr[i][1]] + "(" + arr[i][0] + ", " + arr[i][1] + ")" + " ->");
//                }
//                System.out.println();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (!visited[nx][ny]) {
                if(depth==2){
                    visited[nx][ny]=true;
                    arr[depth][0] = nx;
                    arr[depth][1] = ny;
                    dfs(depth + 1, x, y);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                arr[depth][0] = nx;
                arr[depth][1] = ny;
                dfs(depth + 1, nx, ny);
                visited[nx][ny] = false;
            }

        }
    }
}