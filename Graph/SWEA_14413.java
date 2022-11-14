package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class SWEA_14413 {
    static int n;
    static int m;
    static char matrix[][];
    static int visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            matrix = new char[n][m];
            visited = new int[n][m];
            sc.nextLine();
            int indexX = 0;
            int indexY = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                String string = sc.nextLine();
                for (int j = 0; j < string.length(); j++) {
                    matrix[i][j] = string.charAt(j);
                    if (string.charAt(j) == '?') cnt++;
                    if (string.charAt(j) == '#' || string.charAt(j) == '.') {
                        indexX = i;
                        indexY = j;
                    }
                }
            }
//			System.out.println(indexX+" "+ indexY);
            if (cnt == n * m) {
                System.out.println("#" + test_case + " possible");
                continue;
            }
            boolean isOk = bfs(indexX, indexY);
            if (isOk) System.out.println("#" + test_case + " possible");
            else System.out.println("#" + test_case + " impossible");
        }
    }

    static boolean bfs(int startx, int starty) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startx, starty));
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        visited[startx][starty] = 1;
        while (!queue.isEmpty()) {
            Pair nowPair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx = nowPair.x + dx[i];
                int newy = nowPair.y + dy[i];
                if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                    if (visited[newx][newy] == 0) {
                        if (matrix[nowPair.x][nowPair.y] == '.') {
                            if (matrix[newx][newy] == '?') {
                                matrix[newx][newy] = '#';
                            }
                            if (matrix[newx][newy] != '#') {
                                return false;
                            }
                        }
                        if (matrix[nowPair.x][nowPair.y] == '#') {
                            if (matrix[newx][newy] == '?') {
                                matrix[newx][newy] = '.';
                            }
                            if (matrix[newx][newy] != '.') {
                                return false;
                            }
                        }
                        visited[newx][newy] = 1;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
        return true;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}