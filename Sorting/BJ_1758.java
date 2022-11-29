package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        long cnt=0;
        for (int i = 1; i <= n; i++) {
            int tmp= sc.nextInt();
            data.add(tmp);
        }
        Collections.sort(data, Collections.reverseOrder());

        for (int i = 1; i <= n ; i++) {
            int tmp=data.get(i-1)-(i-1);
            if(tmp<0)continue;
            cnt+=tmp;
        }
        System.out.println(cnt);
    }
}