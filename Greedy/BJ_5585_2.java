package Greedy;

import java.util.Scanner;

class BJ_5585_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []changes={500, 100, 50, 10, 5, 1};
        int money=1000-sc.nextInt();

        int cnt=0;
        for (int change : changes) {
            if(money/change!=0){
                cnt+=money/change;
                money=money%change;
            }
        }
        System.out.println(cnt);
    }
}