package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_16948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int [][] matrix= new int[n][n];
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int r2=sc.nextInt();
        int c2=sc.nextInt();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r1, c1));
        matrix[r1][c1]=1;
        int[] dx={-2, -2, 0, 0, 2, 2};
        int[] dy={-1, 1, -2, 2, -1, 1};
        while (!q.isEmpty()){
            Pair now=q.poll();
            if(now.x==r2&&now.y==c2)break;
            for (int i = 0; i < 6; i++) {
                int newx=dx[i]+now.x;
                int newy=dy[i]+now.y;
                if(newx>=0&&newx<n&&newy>=0&&newy<n){
                    if(matrix[newx][newy]==0){
                        q.offer(new Pair(newx, newy));
                        matrix[newx][newy]=matrix[now.x][now.y]+1;
                    }
                }
            }
        }
        System.out.println(matrix[r2][c2]-1);
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