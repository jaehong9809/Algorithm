package String;

import java.util.Scanner;

class BJ_17202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a= sc.nextLine();
        String b= sc.nextLine();
        String tmp = "";
        for (int i = 0; i < a.length(); i++) {
            tmp+=a.substring(i, i+1);
            tmp+=b.substring(i, i+1);
        }
        while (tmp.length()!=2){
            String tmp2=tmp;
            tmp="";
            for (int i = 0; i < tmp2.length()-1; i++) {
                int sum=tmp2.charAt(i)+tmp2.charAt(i+1)-'0'-'0';
                String tmp3=Integer.toString(sum%10);
                tmp+=tmp3.substring(0, 1);
            }
        }
        System.out.println(tmp);
    }
}