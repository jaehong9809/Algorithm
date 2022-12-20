package Greedy;

import java.util.Scanner;

class BJ_3135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int n= sc.nextInt();
        int min=1000000000;
        for (int i = 0; i < n; i++) {
            int tmp= sc.nextInt();
            int gap=Math.abs(tmp-b);
            if(min>gap){
                min=gap;
            }
        }
        if(min>=Math.abs(a-b)){
            System.out.println(Math.abs(a-b));
            return;
        }
        System.out.println(min+1);
    }
}