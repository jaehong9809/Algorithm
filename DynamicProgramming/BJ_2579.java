package DynamicProgramming;

import java.util.Scanner;

class BJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int list[] = new int[n + 1];
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i]= sc.nextInt();
        }
        dp[1]=list[1];
        dp[2]=list[1]+list[2];
        dp[3] = Math.max(list[1], list[2]) + list[3];
        for (int i = 4; i <= n; i++) {
            dp[i]=Math.max(list[i-1]+dp[i-3], dp[i-2])+list[i];
        }
        System.out.println(dp[n]);

    }
}