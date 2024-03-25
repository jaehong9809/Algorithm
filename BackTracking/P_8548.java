package BackTracking;

import java.util.Scanner;

class P_8548 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static String[] strings;
    static boolean sign=false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();
        strings=new String[n];

        for (int i = 0; i < n; i++) {
            strings[i]=sc.nextLine();
        }
        arr=new int[n];
        visited=new boolean[n];
        dfs(0);
        if(sign) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int depth){
        if(depth==n){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(strings[arr[i]]);
            }
            String origin=sb.toString();
            String reverse= String.valueOf(sb.reverse());

            if (origin.equals(reverse)) {
                sign=true;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i]=true;
                arr[depth]=i;
                dfs(depth+1);
                visited[i]=false;
            }

        }
    }
}