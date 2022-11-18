package Graph;

import java.util.*;

class BJ_2589 {
    static int n, m;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        matrix=new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='W'){
                    matrix[i][j]=0;
                }
                if(str.charAt(j)=='L'){
                    matrix[i][j]=1;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==1){
                    list.add(bfs( i, j));
                }
            }
        }
        System.out.println(Collections.max(list));

    }

    private static int bfs( int startx, int starty) {
        Queue<Pair> queue = new LinkedList<>();
        int tmpMatrix[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpMatrix[i][j]=matrix[i][j];
            }
        }
        queue.offer(new Pair(startx, starty));
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        tmpMatrix[startx][starty]=0;
        int max=0;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if(max<tmpMatrix[now.x][now.y]){
                max = tmpMatrix[now.x][now.y];
            }
            for (int i = 0; i < 4; i++) {
                int newx = now.x + dx[i];
                int newy = now.y + dy[i];
                if(newx>=0&&newy>=0&&newx<n&&newy<m){
                    if(tmpMatrix[newx][newy]==1){
                        tmpMatrix[newx][newy]=tmpMatrix[now.x][now.y]+1;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
        }
        return max;
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