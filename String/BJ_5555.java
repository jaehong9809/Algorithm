package String;

import java.util.Scanner;

class BJ_5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        int n= sc.nextInt();
        sc.nextLine();
        int cnt=0;
        for (int i = 0; i < n; i++) {
            String tmp=sc.nextLine();
            tmp=tmp+tmp+tmp;
            if(tmp.contains(str))cnt++;
        }
        System.out.println(cnt);

    }
}