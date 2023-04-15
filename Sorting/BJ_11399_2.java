package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_11399_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        Collections.sort(data);

        for (int i = 1; i < n; i++) {
            data.set(i, data.get(i)+data.get(i-1));
        }
        int result=0;
        for (Integer datum : data) {
            result+=datum;
        }
        System.out.println(result);
    }
}