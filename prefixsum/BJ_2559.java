package prefixsum;

import java.util.Scanner;

class BJ_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.nextLine();
        String[] lines=sc.nextLine().split(" ");
        int[] data=new int[n];
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(lines[i]);
        }

        for (int i = 1; i <= n; i++) {
            preSum[i] = data[i - 1] + preSum[i - 1];
        }
        int max=-10000001;
        for (int i = k; i <= n ; i++) {
            int sum=preSum[i]-preSum[i-k];
            if(max<sum){
                max=sum;
            }
        }
        System.out.println(max);


    }
}