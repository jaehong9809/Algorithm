package Greedy;

import java.util.Scanner;

public class BJ_2839 {
    static int n;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n= sc.nextInt();
        int result=0;
        while(n>0){
            if(n%5==0){
                n-=5;
                result++;
            }
            else{
                n-=3;
                if(n<0){
                    result=-1;
                    break;
                }
                result++;
            }
        }
        System.out.println(result);
    }

}