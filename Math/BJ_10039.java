package Math;

import java.util.Scanner;

class BJ_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt=0;
        for (int i = 0; i < 5; i++) {
            int tmp=sc.nextInt();
            if(tmp<40){
                cnt+=40;
                continue;
            }
            cnt+=tmp;
        }
        System.out.println(cnt/5);
    }
}