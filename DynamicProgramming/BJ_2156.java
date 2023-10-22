package DynamicProgramming;

import java.util.Scanner;

class BJ_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[10001];
        int[] arr = new int[10001];

        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();
        d[1] = arr[1];
        d[2] = arr[1] + arr[2];
        d[3]=Math.max(arr[1]+arr[3], Math.max(arr[1]+arr[2], arr[2]+arr[3]));
        for (int i = 4; i <= n; i++) {
            d[i] = Math.max(d[i-1], Math.max(d[i - 2] + arr[i], d[i - 3] + arr[i-1]+arr[i]));
        }
        // 9 9 9 1 1 9 9 9
        /*for (int i : d) {
            System.out.printf("%d -> ", i);
        }*/
        System.out.println(d[n]);

    }
}