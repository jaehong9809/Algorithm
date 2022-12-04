package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_17086 {
    static int n;
    static int m;
    static int[][] matrix;
    static ArrayList<Pair> sharks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    sharks.add(new Pair(i, j));
                }
                matrix[i][j] = tmp;
            }
        }
        bfs();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > result) {
                    result = matrix[i][j];
                }
            }
        }
        System.out.println(result - 1);

    }

    private static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        for (Pair shark : sharks) {
            queue.add(new Pair(shark.x, shark.y));
        }
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {1, 0, -1, -1, 1, 1, 0, -1};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newx = dx[i] + now.x;
                int newy = dy[i] + now.y;
                if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                    if (matrix[newx][newy] == 0) {
                        queue.offer(new Pair(newx, newy));
                        matrix[newx][newy] = matrix[now.x][now.y] + 1;
                    }
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