package DynamicProgramming;

import java.util.Scanner;

class BJ_1463_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 3;
        if (n < 6) {
            System.out.println(dp[n]);
            return;
        }
        for (int i = 6; i <= n; i++) {
            long min=2100000000;
            if (i % 3 == 0) {
                min= Math.min(dp[i - 1], dp[i / 3]);
            }
            if (i % 2 == 0) {
                min = Math.min(Math.min(dp[i - 1], dp[i / 2]), min);
            }

            dp[i]=Math.min(min, dp[i-1])+1;

        }
        System.out.println(dp[n]);
    }
}