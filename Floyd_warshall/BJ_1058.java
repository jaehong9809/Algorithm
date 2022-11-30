package Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_1058 {
    static int INF=(int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int matrix[][]=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String str= br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='N'){
                    if(i-1==j){
                        matrix[i][j+1]=0;
                    }else{
                        matrix[i][j+1]=INF;
                    }
                }else{
                    matrix[i][j+1]=1;
                }
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n ; b++) {
                    matrix[a][b]=Math.min(matrix[a][b], matrix[a][k]+matrix[k][b]);
                }
            }
        }
        int max=0;
        for (int i = 1; i <= n ; i++) {
            int cnt=0;
            for (int j = 1; j <= n ; j++) {
                if(matrix[i][j]!=INF&&matrix[i][j]!=0&&matrix[i][j]<=2){
                    cnt++;
                }
            }
            if (max<cnt)max=cnt;
        }

        System.out.println(max);
    }

}