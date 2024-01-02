package Graph;

import java.util.*;

class BJ_14502_2 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row;
    static int col;
    static int[][] matrix;
    static List<int[]> virus = new ArrayList<>();
    static int[][] visited;
    static int[][] arr;
    static int max=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row=sc.nextInt();
        col=sc.nextInt();
        matrix=new int[row][col];
        visited = new int[row][col];
        arr=new int[3][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j]=sc.nextInt();
                if(matrix[i][j]==2){
                    virus.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
        System.out.println(max);
    }
    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for (int[] ints : virus) {
            queue.offer(ints);
        }
        int[][] clone = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                clone[i][j]=matrix[i][j];
            }
        }
        for (int[] ints : arr) {
            clone[ints[0]][ints[1]]=1;
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextx=dx[i]+now[0];
                int nexty=dy[i]+now[1];
                if(!(nextx>=0&&nextx<row&&nexty>=0&&nexty<col))continue;

                if(clone[nextx][nexty]==0){
                    queue.offer(new int[]{nextx, nexty});
                    clone[nextx][nexty]=2;
                }
            }
        }
        int cnt=0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if(clone[i][j]==0)cnt++;
            }
        }
        return cnt;
    }

    public static void dfs(int depth){
        if(depth==3){
            max=Math.max(max, bfs());
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(visited[i][j]==0&&matrix[i][j]==0){
                    visited[i][j]=1;
                    arr[depth][0]=i;
                    arr[depth][1]=j;
                    dfs(depth+1);
                    visited[i][j]=0;
                }
            }
        }

    }

}