package Greedy;

import java.util.Scanner;

class NDB_5 {
    static int n;
    static int m;
    static int[] list=new int[11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp= sc.nextInt();
            list[tmp]++;
        }
        int result=0;
        for (int i = 1; i <=10 ; i++) {
            n-=list[i];
            result+=n*list[i];
        }
        System.out.println(result);
    }
}