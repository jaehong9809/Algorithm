package ToDo;

import java.util.Scanner;

class BJ_17070 {
    static int n;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        matrix=new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
        

    }
}