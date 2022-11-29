package Implementation;

import java.util.Scanner;

class BJ_2167 {
    static int[][]matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        matrix=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp= sc.nextInt();
                matrix[i][j]=tmp;
            }
        }
        int k= sc.nextInt();
        for (int index = 0; index < k; index++) {
            int i= sc.nextInt();
            int j= sc.nextInt();
            int x= sc.nextInt();
            int y= sc.nextInt();
            cal(i, j, x, y);
        }
    }
    public static void cal(int i, int j, int x, int y){
        int cnt=0;
        for (int a = i-1; a < x ; a++) {
            for (int b = j-1; b < y ; b++) {
                cnt+=matrix[a][b];
            }
        }
        System.out.println(cnt);
    }
}