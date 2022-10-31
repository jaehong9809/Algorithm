package Greedy;

import java.util.Scanner;

class NDB_2 {
    static String s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s= sc.nextLine();
        int result=1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                continue;
            }
            result*=(s.charAt(i)-'0');
        }

        System.out.println(result);
    }
}