package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BJ_2573 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] field;
    static Set<Pair> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(s1[j]);
                if(field[i][j]!=0){
                    set.add(new Pair(i, j));
                }
            }
        }
        int islandCnt = 0;
        int cnt = 0;
        while (islandCnt < 2) {
            cnt++;
            checkField();
            islandCnt = bfs();
            if(islandCnt==0){
                cnt=0;
                break;
            }
          /* System.out.println(islandCnt);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(field[i][j]+" ");
                }
                System.out.println();
            }*/
        }
        System.out.println(cnt);
    }

    static int bfs() {
        int islandCnt = 0;
        boolean[][] visited = new boolean[n][m];
        for (Pair pair : set) {
            if (!visited[pair.x][pair.y]) {
                islandCnt++;
                Queue<Pair> queue = new LinkedList<>();
                queue.offer(new Pair(pair.x, pair.y));
                while (!queue.isEmpty()) {
                    Pair poll = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextx = dx[k] + poll.x;
                        int nexty = dy[k] + poll.y;
                        if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m) {
                            if (!visited[nextx][nexty] && field[nextx][nexty] != 0) {
                                queue.offer(new Pair(nextx, nexty));
                                visited[nextx][nexty] = true;
                            }
                        }
                    }
                }
            }
        }
        return islandCnt;
    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static void checkField() {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited=new boolean[n][m];

        for (Pair pair : set) {
            queue.offer(new Pair(pair.x, pair.y));
            visited[pair.x][pair.y]=true;
        }
        set.clear();
        while (!queue.isEmpty()) {
            Pair now= queue.poll();
            int num=0;
            for (int i = 0; i < 4; i++) {
                int nextx=dx[i]+now.x;
                int nexty=dy[i]+now.y;
                if(nextx>=0&&nextx<n&&nexty>=0&&nexty<m){
                    if (field[nextx][nexty]==0&&!visited[nextx][nexty]) {
                        num++;
                    }
                }
            }
            if(field[now.x][now.y]-num<0)field[now.x][now.y]=0;
            else field[now.x][now.y] -= num;
            if(field[now.x][now.y]>0) set.add(new Pair(now.x, now.y));
        }
    }
}