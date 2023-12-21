package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

class BJ_15654 {
    static int[] data;
    static int n;
    static int m;
    static int[] arr;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        data = new int[n];
        arr=new int[m];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);
        dfs(0);


    }
    public static void dfs(int length){
        if(length==m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <n ; i++) {
            if(visited[i]==0){
                visited[i]=1;
                arr[length]=data[i];
                dfs(length+1);
                visited[i]=0;
            }
        }
    }
}