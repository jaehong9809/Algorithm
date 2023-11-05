package BackTracking;

import java.util.Scanner;

class BJ_15649 {
    static int[] arr;
    static int[] checked;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[m];
        checked=new int[n+1];

        dfs(0);


    }

    static void dfs(int depth){
        if(depth==m)
        {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(checked[i]==0){
                checked[i]=1;
                arr[depth]=i;
                dfs(depth+1);
                checked[i]=0;
            }
        }
    }
}