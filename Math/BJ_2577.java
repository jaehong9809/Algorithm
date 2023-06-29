package Math;

import java.util.Scanner;

class BJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=1;
        for (int i = 0; i < 3; i++) {
            a*=sc.nextInt();
        }

        String result=Integer.toString(a);
        int[] data=new int[10];
        for (int i = 0; i < result.length(); i++) {
            data[result.charAt(i)-'0']++;
        }
        for (int datum : data) {
            System.out.println(datum);
        }
    }
}