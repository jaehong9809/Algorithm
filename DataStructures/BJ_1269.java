package DataStructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class BJ_1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        int cnt=0;
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            B.add(sc.nextInt());
        }
        for (Integer integer : B) {
            if(A.contains((int)integer)){
                cnt++;
            }
        }
        for (Integer integer : A) {
            if(B.contains(integer)){
                cnt++;
            }
        }
        System.out.println(n+m-cnt);
    }
}