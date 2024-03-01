package Math;

import java.math.BigInteger;
import java.util.Scanner;

class BJ_10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        BigInteger[] dp=new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1]=new BigInteger("1");
        int n=sc.nextInt();
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1].add(dp[i-2]);
        }
        System.out.println(dp[n]);
    }
}