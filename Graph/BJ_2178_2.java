package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_2178_2 {
    static int[][] matrix=new int[100][100];
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input=sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j]=input.charAt(j)-'0';
            }
        }
      
        bfs();
        System.out.println(matrix[n-1][m-1]);
    }
    public static void bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        int[] dx={-1, 1, 0, 0};
        int[] dy={0, 0, -1, 1};
        while (!queue.isEmpty()){
            Pair now= queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx=dx[i]+now.x;
                int newy=dy[i]+now.y;
                if(newx>=0&& newx<n&&newy>=0&&newy<m){
                    if(matrix[newx][newy]==1){
                        matrix[newx][newy]=matrix[now.x][now.y]+1;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
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