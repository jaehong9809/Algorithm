package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

class BJ_1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputString=sc.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        int index=0;
        for (int i = 0; i < inputString.length()-1; i++) {
            if(inputString.charAt(i)!=inputString.charAt(i+1)){
                strings.add(inputString.substring(index, i+1));
                index=i+1;
            }
        }
        strings.add(inputString.substring(index));
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if(string.charAt(0)=='X'){
                if(string.length()%2!=0){
                    System.out.println(-1);
                    return;
                }else{
                    int a=string.length()/4;
                    int b=(string.length()%4)/2;
                    for (int i = 0; i < a; i++) {
                        sb.append("AAAA");
                    }
                    for (int i = 0; i < b; i++) {
                        sb.append("BB");
                    }
                }
            }else{
                sb.append(string);
            }
        }
        System.out.println(sb.toString());
    }
}