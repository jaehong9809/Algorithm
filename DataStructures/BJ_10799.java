package DataStructures;

import java.util.Scanner;
import java.util.Stack;

class BJ_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        Stack<Character> st = new Stack<>();
        int laizer=0;
        int result=0;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if(now==')' ){
                st.pop();
                if(str.charAt(i-1)=='('){
                    result+=st.size();
                }else{
                    result++;
                }
            }else{
                st.push(now);
            }
        }
        System.out.println(result);
    }
}