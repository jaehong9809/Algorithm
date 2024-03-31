package String;

import java.util.Scanner;

class P_8551 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        boolean sign = false;
        String res="";

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if(left.length()%2!=0|| right.length()%2!=0){
                continue;
            }
            boolean leftsign=false;
            boolean rightsign=false;

            if(left.substring(0, left.length()/2).equals(left.substring(left.length()/2))){
                leftsign=true;
            }
            if(right.substring(0, right.length()/2).equals(right.substring(right.length()/2))){
                rightsign=true;
            }

            if (leftsign && rightsign) {
                res+=left.substring(0, left.length()/2);
                res+=right.substring(0, right.length()/2);
                sign=true;
            }
        }

        if(sign){
            System.out.println("YES");
            System.out.println(res);
        }else{
            System.out.println("NO");
        }
    }
}