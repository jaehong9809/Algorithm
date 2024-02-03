package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

class BJ_11663 {
    static int n, m;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);

        for (int i = 0; i < m; i++) {
            int lowerBound = lowerbound(sc.nextInt());
            int upperBound = upperbound(sc.nextInt());
            System.out.println(upperBound - lowerBound);
        }
    }

    static int upperbound(int target) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    static int lowerbound(int target) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

}