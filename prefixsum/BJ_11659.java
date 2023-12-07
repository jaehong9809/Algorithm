package prefixsum;

import java.util.Scanner;

class BJ_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] data=new int[n+1];
        int[] dd=new int[n+1];
        for (int i = 1; i <= n ; i++) {
            data[i]=sc.nextInt();
            dd[i]=data[i]+dd[i-1];
        }
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(dd[b]-dd[a-1]);
        }
    }
}