package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1012_2 {
    static int[][] matrix;
    static int m;
    static int n;
    static int k;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            matrix = new int[n + 1][m + 1];
            cnt = 0;

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                matrix[b][a] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1) {
                        cnt++;
                        bfs(j, i);

                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int startx, int starty) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startx, starty));
        matrix[starty][startx] = 0;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[ny][nx] == 1) {
                    matrix[ny][nx] = 0;
                    queue.offer(new Pair(nx, ny));
                }
            }

        }

    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}