package Greedy;

import java.util.Scanner;

class BJ_2839_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                n -= 5;
            }else{
                n -= 3;
            }
            cnt++;
        }
        if(n<0){
            System.out.println(-1);
        }else{
            System.out.println(cnt);

        }
    }
}