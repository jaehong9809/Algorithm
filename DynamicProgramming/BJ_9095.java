package DynamicProgramming;

import java.util.Scanner;

class BJ_9095 {
    static int n;
    static int dp[]=new int[12];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        dp[4]=7;
        for (int i = 4; i <12 ; i++) {
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        for (int i = 0; i < n; i++) {
            int a= sc.nextInt();
            System.out.println(dp[a]);
        }
    }
}