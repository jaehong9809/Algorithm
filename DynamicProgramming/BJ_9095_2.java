package DynamicProgramming;

import java.util.Scanner;

class BJ_9095_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int[] dp=new int[12];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        dp[4]=7;
        for (int i = 5; i < 12; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int n= sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}