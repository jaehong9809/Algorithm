package Math;

import java.util.Scanner;

class BJ_2163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m = sc.nextInt();
        int cnt=n-1 + (m-1)*n;
        System.out.println(cnt);

    }
}