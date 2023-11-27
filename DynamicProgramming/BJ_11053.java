package DynamicProgramming;

import java.util.Scanner;

class BJ_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int[] dp=new int[n+1];
        //0 횟수, 1 arr[i]값
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            int maxIndex=-1;
            int max=-1;
            for (int j = i-1; j >-1 ; j--) {
                if(arr[j]<arr[i]){
                    if(dp[j]>max){
                        max=dp[j];
                        maxIndex=j;
                    }
                }
            }
            if(maxIndex==-1){
                dp[i]=1;
            }
            else{
                dp[i]=dp[maxIndex]+1;
            }
        }
        int max=-1;
        for (int i = 0; i < n; i++) {
            if(max<dp[i]){
                max=dp[i];
            }
        }
        System.out.println(max);
    }
}