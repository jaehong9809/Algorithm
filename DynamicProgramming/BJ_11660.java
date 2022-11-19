package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_11660 {
    static int n, m;
    static int[][] matrix;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp=br.readLine();
        String[] s = tmp.split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        matrix = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];
        int total1 = 0;
        int total2 = 0;
        for (int i = 1; i <= n; i++) {
            tmp=br.readLine();
            String[] s1 = tmp.split(" ");
            for (int j = 1; j <= n; j++) {
                matrix[i][j]= Integer.parseInt(s1[j-1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            String str=br.readLine();
            StringTokenizer st=new StringTokenizer(str);
            int x, y, tox, toy;
            x= Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            tox=Integer.parseInt(st.nextToken());
            toy=Integer.parseInt(st.nextToken());
            if(x==tox&&y==toy) {
                System.out.println(matrix[x][y]);
                continue;
            }
            System.out.println(dp[tox][toy] - dp[x - 1][toy] - dp[tox][y-1] + dp[x - 1][y - 1]);
        }

    }

}