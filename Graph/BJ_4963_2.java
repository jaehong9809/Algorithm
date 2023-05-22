package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_4963_2 {
    static int w;
    static int h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            w= sc.nextInt();
            h= sc.nextInt();
            if(w==0&&h==0)break;

            int[][] matrix=new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    int tmp= sc.nextInt();
                    matrix[i][j]=tmp;
                }
            }
            int cnt=0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(matrix[i][j]==1){
                        matrix=bfs(matrix, i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static int[][] bfs(int[][] matrix, int starty, int startx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startx, starty));
        matrix[starty][startx]=0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
        while (!queue.isEmpty()) {
            Pair now=queue.poll();
            for (int i = 0; i < 8; i++) {
                int newx=now.x+dx[i];
                int newy=now.y+dy[i];
                if(newx>=0&&newx<w&&newy>=0&&newy<h){
                    if(matrix[newy][newx]==1){
                        matrix[newy][newx]=0;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
        return matrix;
    }
    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}