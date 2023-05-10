package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_11650_2 {
    static int n;
    static ArrayList<Pair> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            data.add(new Pair(a, b));
        }
        Collections.sort(data);
        for (Pair datum : data) {
            System.out.println(datum.x + " " + datum.y);
        }
    }

    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.x == this.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}