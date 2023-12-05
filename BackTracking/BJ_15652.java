package BackTracking;

import java.util.Scanner;

class BJ_15652 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        arr = new int[m];

        dfs(0, 1);

    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            /*boolean sign=true;
            for (int i = 0; i < m-1; i++) {
                if(arr[i]>arr[i+1])sign=false;
            }
            if(sign){
                for (int i = 0; i < m; i++) {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }*/
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }
}