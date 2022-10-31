package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NDB_4 {

    static int n;
    static ArrayList<Integer> coins = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        int result=1;
        Collections.sort(coins);
        for (int i = 0; i < n; i++) {
            if(result<coins.get(i))break;
            result+=coins.get(i);
        }

        System.out.println(result);
    }
}