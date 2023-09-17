package Implementation;

import java.util.Scanner;

class BJ_2566 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] matrix=new int[10][10];


        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=9 ; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
        int max=-1;
        int row=0;
        int col=0;
        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=9 ; j++) {
                if(max<matrix[i][j]){
                    row=i;
                    col=j;
                    max=matrix[i][j];
                }
            }
        }
        System.out.println(max);
        System.out.println(row+" "+col);

    }
}

