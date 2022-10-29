package DynamicProgramming;

import java.util.Scanner;

class BJ_1149 {
    static int n;
    static int list[][]= new int[1001][3];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        int recent=0;
        for (int i = 1; i <=n ; i++) {
            int a, b, c;
            a= sc.nextInt();
            b= sc.nextInt();
            c= sc.nextInt();
            list[i][0]=Math.min(list[i-1][1], list[i-1][2])+a;
            list[i][1]=Math.min(list[i-1][0], list[i-1][2])+b;
            list[i][2]=Math.min(list[i-1][0], list[i-1][1])+c;

        }

        int result=Math.min(list[n][0], Math.min(list[n][1], list[n][2]));
        System.out.println(result);


    }
}