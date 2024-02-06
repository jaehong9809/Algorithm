package twopointer;

import java.util.Arrays;
import java.util.Scanner;

class BJ_1940_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] items = new int[n];

        for (int i = 0; i < n; i++) {
            items[i] = sc.nextInt();
        }

        Arrays.sort(items);

        int start = 0;
        int end = n - 1;
        int res = 0;

        while (start < end) {
            int sum = items[start] + items[end];

            if (sum < m) {
                start++;
            } else if (sum > m) {
                end--;
            } else {
                res++;
                start++;
                end--;
            }
        }

        System.out.println(res);
    }
}