package Implementation;

import java.util.Scanner;

class BJ_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0;
        for (int i = 1; i <= 10000; i++) {
            int up;
            int down;
            if(i%2==0){
                up=1;
                down=i;
                while (up<=i){
                    cnt++;
                    if(cnt==n){
                        System.out.println(up+"/"+down);
                        return;
                    }
                    up++;
                    down--;
                }
            }else{
                up=i;
                down=1;
                while (down<=i){
                    cnt++;
                    if(cnt==n){
                        System.out.println(up+"/"+down);
                        return;
                    }
                    up--;
                    down++;
                }
            }
        }
    }
}