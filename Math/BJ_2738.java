package Math;

import java.util.Scanner;

class BJ_2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] map1=new int[n][m];
        int[][] map2=new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map1[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map2[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map1[i][j]+=map2[i][j];
                System.out.print(map1[i][j]+" ");
            }
            System.out.println();
        }
    }
}