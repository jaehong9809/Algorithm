package BackTracking;

import java.util.Scanner;

class BJ_15650 {
    static int[] arr;
    static int[] checked;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        checked = new int[n + 1];

        dfs(0, 1);


    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            if (checked[i] == 0) {
                checked[i] = 1;
                arr[depth] = i;
                dfs(depth + 1, i + 1);
                checked[i] = 0;
            }
        }
    }
}