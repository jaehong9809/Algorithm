package Math;

import java.util.Scanner;

class BJ_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if(a==1){
            a=2;
        }
        for (int i = a; i <=b ; i++) {
            if(checkPM(i)) System.out.println(i);
        }

    }

    static private boolean checkPM(int n){

        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}