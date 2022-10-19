package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair{
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
public class BJ_2178 {
    static int n, m;
    static int matrix[][]=new int[101][101];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str= sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                matrix[i][j]=str.charAt(j)-'0';
            }
        }
        bfs(0, 0);
        System.out.println(matrix[n-1][m-1]);
    }
    public static void bfs(int startx, int starty){
        Queue<Pair> queue=new LinkedList<>();
        HashSet<Pair> set=new HashSet<>();
        set.add(new Pair(startx,starty));

        queue.offer(new Pair(startx, starty));

        int dx[]={-1, 1, 0, 0};
        int dy[]={0, 0, 1, -1};
        while(!queue.isEmpty()){
            Pair now=queue.poll();
            int x= now.getX();
            int y=now.getY();
            for (int i = 0; i < 4; i++) {
                int newx=x+dx[i];
                int newy=y+dy[i];
                if(newx>=0&&newx<n&&newy>=0&&newy<m){
                    if(matrix[newx][newy]==1&&matrix[newx][newy]!=0){
                        matrix[newx][newy]+=matrix[x][y];
                        set.add(new Pair(newx,newy));
                        queue.add(new Pair(newx,newy));
                    }
                }
            }

        }


    }

}