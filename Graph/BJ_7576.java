package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_7576 {
    static int n, m;
    static int matrix[][];
    static ArrayList<Pair> igntomato = new ArrayList<>();
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        matrix=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                int tmp=sc.nextInt();
                if(tmp==1){
                    igntomato.add(new Pair(i, j));
                }
                matrix[i][j]=tmp;
            }
        }
        bfs();
        int max=-2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0){
                    System.out.println(-1);

                    return;
                }
                if(max<matrix[i][j]){
                    max=matrix[i][j];
                }
            }
        }
        System.out.println(max-1);
    }

    private static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < igntomato.size(); i++) {
            queue.offer(new Pair(igntomato.get(i).x, igntomato.get(i).y));
        }
        int dx[]={-1, 1, 0, 0};
        int dy[]={0, 0, -1, 1};

        while (!queue.isEmpty()){
            Pair now=queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx=dx[i]+now.x;
                int newy=dy[i]+now.y;
                if(newx>=0&&newx<n&&newy>=0&&newy<m){
                    if(matrix[newx][newy]==0){
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