package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] matrix= new int[n+1][n+1];
        int[][] pSum= new int[n+1][n+1];

        for (int i = 1; i <=n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <=n ; j++) {
                matrix[i][j] = Integer.parseInt(s1[j-1]);
                pSum[i][j]=matrix[i][j]+pSum[i-1][j]+pSum[i][j-1]-pSum[i-1][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s1[0]);
            int y1=Integer.parseInt(s1[1]);
            int x2=Integer.parseInt(s1[2]);
            int y2=Integer.parseInt(s1[3]);
            int result=pSum[x2][y2]-pSum[x1-1][y2]-pSum[x2][y1-1]+pSum[x1-1][y1-1];
            System.out.println(result);
        }
    }
}