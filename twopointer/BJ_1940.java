package twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class BJ_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] items = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            items[i] = sc.nextInt();
        }

        Arrays.sort(items);
        int res=0;
        for (int i = 0; i < n; i++) {
            if(!set.contains(m-items[i])){
                set.add(items[i]);
            }else{
                res++;
            }
        }

        System.out.println(res);
    }
}