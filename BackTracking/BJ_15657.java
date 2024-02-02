package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

class BJ_15657 {
    static int n;
    static int m;
    static int[] data;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[m];
        visited=new boolean[n];
        data=new int[n];
        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);
        dfs(0, 0);
    }


    static void dfs(int depth, int start){
        if(depth==m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth]=data[i];
            dfs(depth+1, i);
        }


    }
}