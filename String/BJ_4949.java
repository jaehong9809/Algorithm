package String;

import java.util.Scanner;
import java.util.Stack;

class BJ_4949 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            String str= sc.nextLine();
            if(str.equals("."))break;
            if(check(str)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
    public static boolean check(String str){
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){
                st.push('(');
            }
            else if(str.charAt(i)==')'){
                if(st.size()==0)return false;
                if(st.peek().equals('(')){
                    st.pop();
                }else{
                    return false;
                }
            }
            if(str.charAt(i)=='['){
                st.push('[');
            }
            else if (str.charAt(i)==']') {
                if(st.size()==0)return false;
                if(st.peek().equals('[')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.size()==0){
            return true;
        }
        else return false;
    }
}