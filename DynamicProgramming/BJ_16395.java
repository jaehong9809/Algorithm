package DynamicProgramming;

import java.util.Scanner;

class BJ_16395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] data=new int[31][31];

        data[1][1]=1;

        for (int i = 2; i <=30 ; i++) {
            for (int j = 1; j <=i ; j++) {
                data[i][j]=data[i-1][j-1]+data[i-1][j];

            }
        }
       

        System.out.println(data[n][k]);
    }
}