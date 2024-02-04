package BinarySearch;

import java.util.Scanner;

class BJ_2417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(binarySearch(n));
    }

    static long binarySearch(long n) {
        long start = 0;
        long res = 0;
        long end = n;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (Math.pow(mid, 2) >= n) {
                res = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return res;
    }
}