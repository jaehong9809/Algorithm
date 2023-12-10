package prefixsum;

import java.util.Scanner;

class BJ_11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] data=new int[n+1];
        int[] preSum=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            data[i]=sc.nextInt();
            preSum[i]=preSum[i-1]+data[i];
        }

        int t=sc.nextInt();

        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int a=sc.nextInt();
            int b=sc.nextInt();

            System.out.println(preSum[b]-preSum[a-1]);
        }
    }
}