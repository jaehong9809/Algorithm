package DataStructures;

import java.util.HashMap;
import java.util.Scanner;

class BJ_10816 {
    static int n, m;
    //10816
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp= sc.nextInt();
            hashMap.put(tmp, hashMap.getOrDefault(tmp, 0)+1);
        }
        m= sc.nextInt();
        for (int i = 0; i < m; i++) {
            int tmp= sc.nextInt();
            System.out.print(hashMap.getOrDefault(tmp, 0)+" ");

        }
    }
}