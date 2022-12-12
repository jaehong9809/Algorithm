package Math;

import java.util.Scanner;

class BJ_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            System.out.println(a*b/gdc(a,b));
        }
    }

    static int gdc(int a, int b){
        int max=0;
        if(a<b){
            max=a;
        }else{
            max=b;
        }
        int result=0;
        for (int i = 1; i <=max ; i++) {
            if(a%i==0&&b%i==0){
                result=i;
            }
        }
        return result;
    }
}