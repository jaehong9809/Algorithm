package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_4963 {
    static int n, m;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int tmp = scanner.nextInt();
                    matrix[i][j] = tmp;
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        matrix[i][j] = 0;
        int dx[] = {-1, 1, 0, 0, 1, 1, -1, -1};
        int dy[] = {0, 0, -1, 1, 1, -1, 1, -1};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int k = 0; k < 8; k++) {
                int newx = now.x + dx[k];
                int newy = now.y + dy[k];
                if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                    if (matrix[newx][newy] == 1) {
                        matrix[newx][newy] = 0;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}