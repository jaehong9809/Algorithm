package BackTracking;

import java.util.Scanner;

class P_8550 {
    static String n;
    static int length;
    static int[] arr;
    static boolean sign=false;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextLine();
        length=n.length();
        arr=new int[length];
        visited=new boolean[length];


        for (int i = 1; i < length; i++) {
            dfs(0, 0, i);
        }
        if(sign) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int depth, int start, int limit){
        if(depth==limit){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < limit; i++) {
                sb.append(n.charAt(arr[i]));
            }
            Integer a=Integer.parseInt(n);
            Integer b = Integer.parseInt(sb.toString());
            if(a%b==0){
                sign=true;
            }
            return;
        }

        for (int i = start; i <length ; i++) {
            if (!visited[i]) {
                visited[i]=true;
                arr[depth]=i;
                dfs(depth+1, i, limit);
                visited[i]=false;
            }
        }


    }
}