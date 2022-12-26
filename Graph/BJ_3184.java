package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_3184 {
    static int r, c;
    static char[][] matrix;
    static int result_wolf;
    static int result_sheep;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r= sc.nextInt();
        c= sc.nextInt();
        matrix=new char[r][c];
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            String str=sc.nextLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j]=str.charAt(j);
            }
        }


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(matrix[i][j]!='#'){
                    bfs(i, j);
                }
            }
        }
        System.out.println(result_sheep+" "+result_wolf);

    }

    private static void bfs(int startx, int starty) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startx, starty));


        int[] dx = {-1, 1, 0, 0,};
        int[] dy = {0, 0, -1, 1};
        int wolves=0;
        int sheeps=0;
        if(matrix[startx][starty]=='v')wolves++;
        if(matrix[startx][starty]=='o')sheeps++;
        matrix[startx][starty]='#';
        while (!queue.isEmpty()) {
            Pair now=queue.poll();

            for (int i = 0; i < 4; i++) {
                int newx=dx[i]+now.x;
                int newy=dy[i]+now.y;
                if(newx>=0&&newx<r&&newy>=0&&newy<c){
                    if(matrix[newx][newy]!='#'){
                        if(matrix[newx][newy]=='v')wolves++;
                        if(matrix[newx][newy]=='o')sheeps++;
                        matrix[newx][newy]='#';
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
        if(wolves>=sheeps){
            result_wolf+=wolves;
        }else{
            result_sheep+=sheeps;
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