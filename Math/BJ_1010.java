package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_1010 {
    static int n;
    static int m;
    static int[][] dp=new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[0][0]=1;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if(i==j)dp[i][j]=1;
                if(j==0)dp[i][j]=1;
            }
        }
        for (int i = 1; i <30; i++) {
            for (int j = 1; j <i ; j++) {
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            String[] temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            m = Integer.parseInt(temp[1]);
            if(n==m|| n==0){
                System.out.println(1);
            }else{
                System.out.println(dp[m][n]);
            }

        }
    }


}