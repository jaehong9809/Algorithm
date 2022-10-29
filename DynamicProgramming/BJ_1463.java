package DynamicProgramming;

import java.util.Scanner;

class BJ_1463 {
    static int n;
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int cnt=0;
        dp=new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+1;

            if(i%2==0){
                dp[i]=Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i], dp[i/3]+1);
            }

        }
        System.out.println(dp[n]);
    }
}