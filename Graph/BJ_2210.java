package Graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class BJ_2210 {
    static int[][] graph=new int[5][5];
    static int[] arr=new int[6];
    static Set<String> strings = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                graph[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0);
            }
        }
        System.out.println(strings.size());
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void dfs(int startx, int starty, int depth) {
        if(depth==6){
            String str = "";
            for (int i = 0; i < 6; i++) {
                str+=Integer.toString(arr[i]);
            }
            strings.add(str);
            return;
        }
        arr[depth]=graph[startx][starty];
        for (int i = 0; i <4 ; i++) {
            int nextx=dx[i]+startx;
            int nexty=dy[i]+starty;
            if(nextx>=0&&nextx<5&&nexty>=0&&nexty<5){
                dfs(nextx, nexty, depth+1);
            }
        }
    }

}