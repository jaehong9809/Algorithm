package String;

import java.util.Scanner;
import java.util.Stack;

class BJ_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean sign=false;
        for (int i = 0; i <str.length() ; i++) {
            char now = str.charAt(i);


            if(now=='<'){
                sign=true;
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
            if(now=='>'){
                sb.append(now);
                sign=false;
                continue;
            }

            if(sign){
                sb.append(now);
            }else{
                if(now==' '){
                    while (!st.isEmpty()) {
                        sb.append(st.pop());
                    }
                    sb.append(' ');
                    continue;
                }
                st.push(now);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);
    }
}