package DataStructures;

import java.util.Scanner;
import java.util.Stack;

class BJ_10773_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {

            int a= sc.nextInt();
            if(a==0){
                st.pop();
                continue;
            }
            st.push(a);
        }
        int cnt=0;
        for (Integer integer : st) {
            cnt+=integer;
        }
        System.out.println(cnt);
    }
}