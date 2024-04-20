package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Solution_pickupitem {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];

        for (int i = 0; i < rectangle.length; i++) {
            int startx = rectangle[i][0];
            int starty = rectangle[i][1];
            int endx = rectangle[i][2];
            int endy = rectangle[i][3];

            for (int j = startx * 2; j <= endx * 2; j++) {
                for (int k = starty * 2; k <= endy * 2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < rectangle.length; i++) {
            int startx = rectangle[i][0];
            int starty = rectangle[i][1];
            int endx = rectangle[i][2];
            int endy = rectangle[i][3];

            for (int j = startx * 2 + 1; j <= endx * 2 - 1; j++) {
                for (int k = starty * 2 + 1; k <= endy * 2 - 1; k++) {
                    map[j][k] = 0;
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
                    if (map[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        map[nx][ny] = map[now[0]][now[1]] + 1;
                    }
                }
            }
        }

        int answer = map[itemX][itemY] / 2;
        return answer;
    }
}