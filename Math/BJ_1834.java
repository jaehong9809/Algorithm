package Math;

import java.util.Scanner;

class BJ_1834 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long mod=n-1;
        long sum=0;

        for (int i = 1; i <= mod; i++) {
            sum+=((long) n *i)+i;
        }
        System.out.println(sum);

    }
}