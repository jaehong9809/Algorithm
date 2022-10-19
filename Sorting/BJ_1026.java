package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class BJ_1026 {
    static int n;
    static ArrayList<Integer> a=new ArrayList<>();
    static ArrayList<Integer> b=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        Collections.sort(a);
        Collections.sort(b, Comparator.reverseOrder());
        int result=0;
        for (int i = 0; i < n; i++) {
            result+=a.get(i)*b.get(i);
        }
        System.out.println(result);
    }
}