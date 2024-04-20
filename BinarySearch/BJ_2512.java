package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

class BJ_2512 {
    static int n, k;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            total += data[i];
        }
        Arrays.sort(data);
        k = sc.nextInt();
        if (total <= k) {
            System.out.println(data[data.length - 1]);
            return;
        }

        int result = bs();
        System.out.println(result);
    }

    static int bs() {
        int start = 1;
        int end = data[data.length - 1];
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int datum : data) {
                if (datum > mid) {
                    total += mid;
                } else {
                    total += datum;
                }
            }

            if (total > k) {
                end = mid - 1;
            } else {
                res = mid;
                start = mid + 1;
            }
        }
        return res;
    }


}