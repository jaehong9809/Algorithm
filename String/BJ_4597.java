package String;

import java.util.Scanner;

class BJ_4597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String str=sc.nextLine();
            if (str.equals("#")) {
                break;
            }
            int odd=0;
            for (int i = 0; i < str.length()-1; i++) {
                if(str.charAt(i)=='1'){
                    odd++;
                }
            }
            String tmp = str.substring(0, str.length() - 1);
            if(str.charAt(str.length()-1)=='e'){
                if(odd%2==0){
                    tmp+="0";;
                }else{
                    tmp+="1";
                }
            }else{
                if(odd%2==0){
                    tmp+="1";;
                }else{
                    tmp+="0";
                }
            }
            System.out.println(tmp);
        }
    }
}