package Graph;

import java.util.Scanner;

class BJ_16953 {
    static long a, b;
    static boolean ok;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a= sc.nextLong();
        b= sc.nextLong();
        dfs(a, Long.valueOf(1));
        if(ok==false){
            System.out.println(-1);
        }
    }

    private static void dfs(Long a, Long count) {
        if(a==b){
            System.out.println(count);
            ok=true;
        }
        if(a*2<=b){
            dfs(a*2, count+1);
        }
        String s=Long.toString(a)+"1";
        long addOne = Long.parseLong(s);
        if(addOne<=b){
            dfs(addOne, count+1);
        }
    }
}