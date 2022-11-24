package DynamicProgramming;

import java.util.Scanner;

class BJ_1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int n= sc.nextInt();
            int fibo[]=new int[41];
            int zerodp[]=new int[41];
            int onedp[]=new int[41];
            fibo[0]=0;
            fibo[1]=1;
            zerodp[0]=1;
            zerodp[1]=0;
            onedp[0]=0;
            onedp[1]=1;
            for (int i = 2; i <= n; i++) {
                fibo[i]=fibo[i-1]+fibo[i-2];
                zerodp[i]=zerodp[i-1]+zerodp[i-2];
                onedp[i]=onedp[i-1]+fibo[i-2];
            }
            System.out.println(zerodp[n]+" "+onedp[n]);
        }
    }
}