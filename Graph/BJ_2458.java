package Graph;

import java.util.Scanner;

class BJ_2458 {
    static int matrix[][];
    static int INF= (int) 1e9;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();m= sc.nextInt();
        matrix = new int[n + 1][n + 1];

        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=n; j++) {
                if(i==j)continue;
                matrix[i][j]=INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            a= sc.nextInt();
            b= sc.nextInt();
            matrix[a][b]=1;
        }
        for (int k = 1; k <=n; k++) {
            for (int a = 1; a <=n; a++) {
                for (int b = 1; b <=n ; b++) {
                    matrix[a][b]=Math.min(matrix[a][b], matrix[a][k]+matrix[k][b]);
                }
            }
        }
        int result=0;
        for (int i = 1; i <=n; i++) {
            int cnt=0;
            for (int j = 1; j <=n; j++) {
                if(matrix[i][j]>0&&matrix[i][j]<INF){
                    cnt++;
                }
                if(matrix[j][i]>0&&matrix[j][i]<INF){
                    cnt++;
                }
            }
            if(cnt==n-1){
                result++;
            }
        }
        System.out.println(result);
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}