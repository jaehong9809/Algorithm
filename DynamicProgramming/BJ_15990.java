package DynamicProgramming;

import java.io.*;

class BJ_15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100000 + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % 1_000_000_009;
        }
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int n = Integer.parseInt(br.readLine());

            long result = (dp[n][1] + dp[n][2] + dp[n][3])%1000000009;
            sb.append(result).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}