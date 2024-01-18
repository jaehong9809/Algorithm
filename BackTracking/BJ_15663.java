package BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class BJ_15663 {
    static int n;
    static int m;
    static int[] arr;
    static int[] visited;
    static int[] data;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();;
        m=sc.nextInt();
        arr=new int[m];
        visited=new int[n];
        data=new int[n];
        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);

        dfs(0);

    }
    public static void dfs(int depth){
        if(depth==m){
            String str="";
            for (int i = 0; i < m; i++) {
                str+=Integer.toString(arr[i])+" ";

            }
            if(set.contains(str)){
                return;
            }
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            set.add(str);
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                visited[i]=1;
                arr[depth]=data[i];
                dfs(depth+1);
                visited[i]=0;
            }
        }

    }
}