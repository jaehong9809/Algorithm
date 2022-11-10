package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_7562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int startx = sc.nextInt();
            int starty = sc.nextInt();
            int endx = sc.nextInt();
            int endy = sc.nextInt();
            if(startx==endx&&starty==endy){
                System.out.println(0);
                continue;
            }
            int result=bfs( matrix, startx, starty, endx, endy, n);
            System.out.println(result);
        }

    }

    private static int bfs( int[][] matrix, int startx, int starty, int endx, int endy, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startx, starty));
        int dx[] = {-2, -1, -2, -1, 1, 2, 1, 2};
        int dy[] = {1, 2, -1, -2, 2, 1, -2, -1};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if(now.x==endx&&now.y==endy){
                break;
            }
            for (int i = 0; i < 8; i++) {
                int newx=now.x+dx[i];
                int newy=now.y+dy[i];
                if(newx>=0&&newx<n&&newy>=0&&newy<n){
                    if(matrix[newx][newy]==0){
                        matrix[newx][newy]=matrix[now.x][now.y]+1;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
        return matrix[endx][endy];
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}