package DataStructures;

import java.util.Arrays;
import java.util.Scanner;

class BJ_15903_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m= sc.nextInt();
        long[] data=new long[n];
        for (int i = 0; i < n; i++) {
            data[i]=sc.nextLong();
        }

        Arrays.sort(data);

        for (int i = 0; i <m ; i++) {
            long tmp=data[0]+data[1];
            data[0]=tmp;
            data[1]=tmp;
            Arrays.sort(data);
        }
        long result=0;
        for (int i = 0; i < n; i++) {
            result+=data[i];
        }

        System.out.println(result);

    }
}