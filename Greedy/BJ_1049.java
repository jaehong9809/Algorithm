package Greedy;

import java.util.Arrays;
import java.util.Scanner;

class BJ_1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] setPrice=new int[m];
        int[] onePrice=new int[m];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split(" ");
            setPrice[i] = Integer.parseInt(s[0]);
            onePrice[i] = Integer.parseInt(s[1]);
        }
        if(n==0){
            System.out.println(0);
            return;
        }
        Arrays.sort(setPrice);
        Arrays.sort(onePrice);
        int setCnt=n/6;
        int oneCnt=n%6;
        int result=0;
        if(setCnt>=1){
            if(setPrice[0]<onePrice[0]*6){
                result+=setCnt*setPrice[0];
            }else{
                result += setCnt * onePrice[0] * 6;
            }

            if(oneCnt>0){
                if(oneCnt*onePrice[0]<setPrice[0]){
                    result+=oneCnt*onePrice[0];
                }else{
                    result+=setPrice[0];
                }
            }
        }else{
            if(oneCnt*onePrice[0]<setPrice[0]){
                result+=oneCnt*onePrice[0];
            }else{
                result+=setPrice[0];
            }
        }
        System.out.println(result);
    }
}