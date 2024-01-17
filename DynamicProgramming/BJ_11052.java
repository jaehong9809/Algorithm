package DynamicProgramming;

import java.util.Scanner;

class BJ_11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] money=new int[n+1];

        for (int i = 1; i <= n; i++) {
            money[i]=sc.nextInt();
        }
        if(n==1){
            System.out.println(money[1]);
            return;
        }
        int[] dp=new int[n+1];
        dp[1]=money[1];
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i]=Math.max(dp[i], dp[i-j]+money[j]);
            }
        }

        System.out.println(dp[n]);
    }
}