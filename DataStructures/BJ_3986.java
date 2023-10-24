package DataStructures;

import java.util.Scanner;
import java.util.Stack;

class BJ_3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        int cnt=0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String s = sc.nextLine();

            for (int j = 0; j < s.length(); j++) {

                if(stack.isEmpty()){
                    stack.push(s.charAt(j));
                }
                else{
                    if(stack.peek().equals(s.charAt(j))){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(j));
                    }
                }
            }

            if(stack.isEmpty()){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}