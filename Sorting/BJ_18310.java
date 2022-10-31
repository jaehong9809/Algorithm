package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_18310 {
    static int n;
    static ArrayList<Integer> ary = new ArrayList<>();  //거리의 합이 최소가 되려면 가운데에 위치해야 한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            ary.add(sc.nextInt());
        }
        Collections.sort(ary);

        int result=0;
        int index = (ary.size() - 1) / 2;
        System.out.println(ary.get(index));

    }

}