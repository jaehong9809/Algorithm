package String;

import java.util.Scanner;
import java.util.Stack;

class BJ_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str=sc.nextLine();
            Stack<Character> st = new Stack<>();
            boolean sign=true;
            for (int j = 0; j < str.length(); j++) {

                if(str.charAt(j)=='('){
                    st.push(str.charAt(j));
                }
                if(str.charAt(j)==')'){
                    if(st.isEmpty()){
                        sign=false;
                        continue;
                    }
                    st.pop();
                }
            }
            if(st.isEmpty()&&sign){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}