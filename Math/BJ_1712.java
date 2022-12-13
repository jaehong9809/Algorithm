package Math;

import java.util.Scanner;

class BJ_1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        if(b==c){
            System.out.println(-1);
            return;
        }
        int result=a/(c-b)+1;
        if(result<=0){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}