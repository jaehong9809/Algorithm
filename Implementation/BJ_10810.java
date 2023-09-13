package Implementation;

import java.util.Arrays;
import java.util.Scanner;

class BJ_10810 {
    static int[] buckets;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        buckets=new int[n+1];
        Arrays.fill(buckets, 0);
        for (int index = 0; index < m; index++) {
            int i=sc.nextInt();
            int j=sc.nextInt();
            int k=sc.nextInt();

            for (int node = i; node <= j; node++) buckets[node]=k;

        }
        for (int i = 1; i <= n; i++) {
            System.out.print(buckets[i]+" ");
        }
    }
}