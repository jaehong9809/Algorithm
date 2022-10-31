package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NDB_1 {
    static int n;
    static ArrayList<Integer> groups=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();

        for (int i = 0; i < n; i++) {
            groups.add(sc.nextInt());
        }
        Collections.sort(groups);
        int cnt=0;
        for (int i = 0; i < groups.size(); i++) {
            int index=groups.get(i);
            i=i+index+1;
            cnt++;
        }
        System.out.println(cnt);

    }
}