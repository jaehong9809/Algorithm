package Graph;

import java.util.*;

class BJ_2667_2 {
    static int n;
    static int[][] matrix;
    static ArrayList<Integer> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            for (int j = 0; j < tmp.length(); j++) {
                matrix[i][j] = tmp.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(data.size());
        Collections.sort(data);
        for (Integer datum : data) {
            System.out.println(datum);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        matrix[i][j] = 0;
        int cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            cnt++;
            for (int k = 0; k < 4; k++) {
                int newX = dx[k] + now.x;
                int newY = dy[k] + now.y;
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && matrix[newX][newY] == 1) {
                    matrix[newX][newY] = 0;
                    queue.offer(new Pair(newX, newY));
                }
            }
        }
        data.add(cnt);
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