package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

class BJ_15655 {
    static int n;
    static int m;
    static int[] data;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        visited=new boolean[n];
        data=new int[n];
        arr = new int[m];
        for (int i = 0; i <n ; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);
        dfs(0, 0);
    }

    public static void dfs(int start, int depth){
        if(depth==m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i =start; i <n ; i++) {
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=data[i];
                dfs(i, depth+1);
                visited[i]=false;
            }
        }
    }
}