package Graph;

import java.util.LinkedList;
import java.util.Queue;

class PG_pickupItem {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] matrix = new int[101][101];
        matrix = printRect(matrix, rectangle);
        matrix = bfs(matrix, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return matrix[itemY * 2][itemX * 2]/2;
    }

    static int[][] bfs(int[][] matrix, int y, int x, int ty, int tx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[101][101];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101) {
                    if (!visited[nx][ny] && matrix[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        matrix[nx][ny] = matrix[now[0]][now[1]] + 1;
                    }
                }
            }
        }
        return matrix;
    }

    static public int[][] printRect(int[][] matrix, int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = rectangle[i][1] * 2; j <= rectangle[i][3] * 2; j++) {
                for (int k = rectangle[i][0] * 2; k <= rectangle[i][2] * 2; k++) {
                    matrix[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = rectangle[i][1] * 2 + 1; j <= rectangle[i][3] * 2 - 1; j++) {
                for (int k = rectangle[i][0] * 2 + 1; k <= rectangle[i][2] * 2 - 1; k++) {
                    matrix[j][k] = 0;
                }
            }
        }
        return matrix;
    }
}