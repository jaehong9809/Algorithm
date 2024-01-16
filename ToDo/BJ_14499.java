package ToDo;

import java.util.Scanner;

class BJ_14499 {
    static int n;
    static int m;
    static int x;
    static int y;
    static int k;
    static int[][] map;
    static int bottom=0;
    static int top=0;
    static int back=0;
    static int front=0;
    static int right=0;
    static int left=0;

    static int[] dir;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][m];
        dir=new int[k];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            dir[i]=sc.nextInt();
        }
        if(map[y][x]!=0){
            bottom=map[y][x];
            map[y][x]=0;
        }
        for (int direct : dir) {
            if(direct==1){
                if(x+1>=m) continue;
                int tmp=right;
                right=top;
                top=left;
                left=bottom;
                bottom=tmp;
                x++;
            }else if (direct==2){
                if(x-1<0) continue;
                int tmp=left;
                left=top;
                top=right;
                right=bottom;
                bottom=tmp;
                x--;
            }else if(direct==3){
                if(y-1<0)continue;
                int tmp=back;
                back=top;
                top=front;
                front=bottom;
                bottom=tmp;

                y--;
            }else{
                if(y+1>=n) continue;
                int tmp=front;
                front=top;
                top=back;
                back=bottom;
                bottom=tmp;
                y++;
            }
            //System.out.println("y ="+y+", x="+x);
            if(map[y][x]==0){
                map[y][x]=bottom;
            }else{
                bottom=map[y][x];
                map[y][x]=0;
            }
            System.out.println(top);
        }
    }

}