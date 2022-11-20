package Graph;

import java.util.*;

class BJ_1926 {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int matrix[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==1){
                    list.add(bfs(matrix, i, j));
                }
            }
        }
        if(list.size()==0){
            System.out.println(0);
            System.out.println(0);
        }else{
            System.out.println(list.size());
            System.out.println(Collections.max(list));

        }
    }

    private static Integer bfs(int matrix[][], int startx, int starty) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startx, starty));
        matrix[startx][starty]=0;
        int dx[]={-1, 1, 0, 0};
        int dy[]={0, 0, -1, 1};
        int cnt=0;
        while (!queue.isEmpty()) {
            Pair now= queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(matrix[nx][ny]==1){
                        matrix[nx][ny]=0;
                        queue.offer(new Pair(nx, ny));
                    }
                }
            }
        }
        return cnt;
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