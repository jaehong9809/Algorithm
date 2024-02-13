package String;

import java.util.Scanner;

class BJ_1254 {
    static int min=10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String reverse = new StringBuilder(str).reverse().toString();
        int len = str.length();

        for (int i = 0; i <= len-1; i++) {
            for (int j = i; j <= len; j++) {
                String tmp=str;
                tmp+=reverse.substring(i, j);

                String revtmp = new StringBuilder(tmp).reverse().toString();
                if (tmp.equals(revtmp)) {
                    min = Math.min(min, tmp.length());
                }
            }
        }

        System.out.println(min);
    }
}