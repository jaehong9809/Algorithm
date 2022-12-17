package String;

import java.util.Scanner;

class BJ_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String input = sc.nextLine();
        int result=0;
        for (int i = 0; i < doc.length(); i++) {
            String tmp=doc.substring(i);
            if (tmp.indexOf(input)>=0){
                result++;
                i+=tmp.indexOf(input)+input.length()-1;
            }
        }
        System.out.println(result);
    }
}