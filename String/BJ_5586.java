package String;

import java.util.Scanner;

class BJ_5586 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
        int a=0;
        int b=0;
        for (int i = 0; i < input.length()-2; i++) {
            if(input.substring(i, i+3).equals("JOI")){
                a++;
            }
            if(input.substring(i, i+3).equals("IOI")){
                b++;
            }
        }
        System.out.println(a);
        System.out.println(b);

    }
}