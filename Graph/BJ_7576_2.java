package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_2 {
    static int n;
    static int m;
    static int[][] matrix;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        m = Integer.parseInt(inputs[0]);
        n = Integer.parseInt(inputs[1]);
        matrix=new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1){
                    queue.offer(new Node(i, j));
                }
            }
        }
        int result = bfs();
        boolean fail=false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0) {
                    fail = true;
                    break;
                }
            }
        }
        if(fail){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    private static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int max=0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nowCol = node.getCol();
            int nowRow = node.getRow();
            for (int i = 0; i < 4; i++) {
                int newCol=dx[i]+nowCol;
                int newRow=dy[i]+nowRow;
                if (newCol >= 0 && newCol < m && newRow >= 0 && newRow < n && matrix[newRow][newCol]==0) {
                    queue.offer(new Node(newRow, newCol));
                    matrix[newRow][newCol]=matrix[nowRow][nowCol]+1;
                    if(matrix[newRow][newCol]>max)max=matrix[newRow][newCol];
                }
            }
        }
        if(max==0){
            return 0;
        }
        else{
            return max-1;
        }

    }

    static class Node{
        final private int  row;
        final private int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
