package Greedy;

import java.util.Scanner;

class BJ_1439 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s= sc.nextLine();
        String[] str1=s.split("1");

        String[] str2=s.split("0");
        int cnt1=0;
        int cnt0=0;
        for (int i = 0; i < str1.length; i++) {
            if(str1[i].equals(""))continue;
            cnt0++;
        }
        for (int i = 0; i < str2.length; i++) {
            if(str2[i].equals(""))continue;
            cnt1++;
        }

        System.out.println(Math.min(cnt1, cnt0));

    }
}