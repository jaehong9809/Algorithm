package Implementation;

import java.util.Scanner;

class BJ_5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='A'||s.charAt(i)=='B'||s.charAt(i)=='C'){
                cnt+=3;
            }
            if(s.charAt(i)=='D'||s.charAt(i)=='E'||s.charAt(i)=='F'){
                cnt+=4;
            }
            if(s.charAt(i)=='G'||s.charAt(i)=='H'||s.charAt(i)=='I'){
                cnt+=5;
            }
            if(s.charAt(i)=='J'||s.charAt(i)=='K'||s.charAt(i)=='L'){
                cnt+=6;
            }
            if(s.charAt(i)=='M'||s.charAt(i)=='N'||s.charAt(i)=='O'){
                cnt+=7;
            }
            if(s.charAt(i)=='P'||s.charAt(i)=='Q'||s.charAt(i)=='R'||s.charAt(i)=='S'){
                cnt+=8;
            }
            if(s.charAt(i)=='T'||s.charAt(i)=='U'||s.charAt(i)=='V'){
                cnt+=9;
            }
            if(s.charAt(i)=='Y'||s.charAt(i)=='Z'||s.charAt(i)=='W'||s.charAt(i)=='X'){
                cnt+=10;
            }
        }
        System.out.println(cnt);

    }
}