package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

class BJ_1654 {
    static int n, k;
    static long[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        data = new long[k];

        for (int i = 0; i < k; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);

        long result = binarySearch();
        System.out.println(result);

    }

    static long binarySearch() {
        long start = 1;
        long end = data[data.length - 1];
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i] / mid;
            }
            if (total >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}