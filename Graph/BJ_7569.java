package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_7569 {
    static int n, m, h;
    static int[][][] matrix;
    static ArrayList<Pair> ign=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m= sc.nextInt();
        n= sc.nextInt();
        h= sc.nextInt();
        matrix=new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int tmp= sc.nextInt();
                    if(tmp==1){
                        ign.add(new Pair(k, j, i));
                    }
                    matrix[i][j][k]=tmp;
                }
            }
        }

        bfs();
        int max=-2;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                   if(matrix[i][j][k]>max)max=matrix[i][j][k];
                   if(matrix[i][j][k]==0){
                       System.out.println(-1);
                       return;
                   }
                }
            }
        }
        System.out.println(max-1);
    }

    private static void bfs() {
        Queue<Pair> queue=new LinkedList<>();
        for(int i = 0; i < ign.size(); i++) {
            queue.offer(new Pair(ign.get(i).x, ign.get(i).y, ign.get(i).z));
        }
        int dx[]={-1, 1, 0, 0, 0, 0};
        int dy[]={0, 0, 1, -1, 0, 0};
        int dz[] = {0, 0, 0, 0, -1, 1};
        while (!queue.isEmpty()){
            Pair now= queue.poll();
            for (int i = 0; i < 6; i++) {
                int newx= now.x+dx[i];
                int newy=now.y+dy[i];
                int newz=now.z+dz[i];
                if(newx>=0&&newx<m&&newy>=0&&newy<n&&newz>=0&&newz<h){
                    if(matrix[newz][newy][newx]==0){
                        matrix[newz][newy][newx]=matrix[now.z][now.y][now.x]+1;
                        queue.offer(new Pair(newx, newy, newz));
                    }
                }
            }
        }
    }

    static class Pair{
        public int x;
        public int y;
        public int z;
        public Pair(int x, int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
}