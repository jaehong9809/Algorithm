package Implementation;

import java.util.Scanner;

class BJ_1018 {
    static int n;
    static int m;
    static char[][] matrix;
    static int min=2501;

    static char[][] map1={
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'}
    };
    static char[][] map2={
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'},
            {'B','W', 'B','W', 'B','W', 'B', 'W'},
            {'W', 'B','W', 'B','W', 'B','W', 'B'}
    };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        matrix=new char[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str=sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j]=str.charAt(j);
            }
        }
        check();
        System.out.println(min);
    }
    public static void check(){
        for (int i = 0; i <n-8+1 ; i++) {
            for (int j = 0; j < m - 8 + 1; j++) {
                char[][] tmp=new char[8][8];
                int x=0;
                for (int k = i; k <i+8 ; k++) {
                    int y=0;
                    for (int l = j; l <j+8 ; l++) {
                        tmp[x][y]=matrix[k][l];
                        y++;
                    }
                    x++;
                }
                isItChess(tmp);
            }
        }
    }

    private static void isItChess(char[][] tmp) {
        int cnt1=0;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if(tmp[i][j]!=map1[i][j]){
                    cnt1++;
                }
            }
        }
        min = Math.min(min, cnt1);
        int cnt2=0;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if(tmp[i][j]!=map2[i][j]){
                    cnt2++;
                }
            }
        }
        min = Math.min(min, cnt2);
    }

}