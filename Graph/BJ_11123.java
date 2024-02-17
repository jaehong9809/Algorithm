package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_11123 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            bfs(sc);
        }
    }

    static void bfs(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#' && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = dx[k] + now[0];
                            int ny = dy[k] + now[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (!visited[nx][ny] && map[nx][ny] == '#') {
                                    queue.offer(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}