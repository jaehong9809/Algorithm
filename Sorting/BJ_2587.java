package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(sc.nextInt());
        }

        Collections.sort(datas);
        int cnt=0;
        for (Integer data : datas) {
            cnt+=data;
        }
        System.out.println(cnt/5);
        System.out.println(datas.get(2));
    }

}