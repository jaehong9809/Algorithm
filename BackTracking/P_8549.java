package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

class P_8549 {
    static int n, target;
    static String str;
    static char[] words;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        target=sc.nextInt();
        sc.nextLine();
        str=sc.nextLine();
        words=new char[n];
        arr=new int[target];
        for (int i = 0; i < n; i++) {
            words[i]=str.charAt(i);
        }
        Arrays.sort(words);
        dfs(0);
    }

    static void dfs(int depth){
        if(depth==target){
            for (int i = 0; i <target ; i++) {
                System.out.print(words[arr[i]]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth]=i;
            dfs(depth+1);
        }

    }
}