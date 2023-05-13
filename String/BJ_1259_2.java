package String;

import java.util.Scanner;

class BJ_1259_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String str=sc.nextLine();
            if(str.equals("0")){
                break;
            }
            StringBuilder palindrom=new StringBuilder(str);
            palindrom.reverse();
            if(str.equals(palindrom.toString())){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }

    }
}