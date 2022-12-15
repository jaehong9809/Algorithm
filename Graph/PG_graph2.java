package Graph;

import java.util.LinkedList;
import java.util.Queue;

class PG_graph2 {
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        maps[0][0] = 1;
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx = dx[i] + now.x;
                int newy = dy[i] + now.y;
                if (newx >= 0 && newx < maps.length && newy >= 0 && newy < maps[0].length) {
                    if (maps[newx][newy] == 1) {
                        maps[newx][newy] = maps[now.x][now.y] + 1;
                        queue.offer(new Pair(newx, newy));
                    }
                }

            }
        }
        answer = maps[maps.length-1][maps[0].length-1];
        if (answer == 1) {
            return -1;
        }
        return answer;
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



