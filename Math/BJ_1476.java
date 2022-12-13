package Math;

import java.util.Scanner;

class BJ_1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        int e=0;
        int s=0;
        int m=0;
        int year=0;
        while (true){
            if(e==a&&s==b&&c==m){
                System.out.println(year);
                break;
            }
            e++;
            s++;
            m++;
            if(e==16){
                e=1;
            }
            if(s==29){
                s=1;
            }
            if(m==20){
                m=1;
            }
            year++;

        }
    }
}