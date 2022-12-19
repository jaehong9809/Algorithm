package String;

import java.util.Scanner;

class BJ_14490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(":");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int min = Math.min(a, b);
        int div=0;
        for (int i = 1; i <= min; i++) {
            if(a%i==0&&b%i==0){
                div=i;
            }
        }
        System.out.println((a/div)+":"+(b/div));
    }
}