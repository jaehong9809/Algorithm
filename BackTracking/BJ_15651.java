package BackTracking;

import java.io.IOException;
import java.util.Scanner;

class BJ_15651 {
    static int n;
    static int m;
    static int[] arr;
    static int[] checked;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        arr=new int[m+1];
        checked=new int[n+1];
        dfs(0);
        System.out.println(stringBuilder);
    }

    static void dfs(int depth) throws IOException {
        if(depth==m){
            for (int i = 0; i < m; i++) {
                stringBuilder.append(arr[i]+" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[depth]=i;
            dfs(depth+1);
        }
    }

}