package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BJ_10828 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            String[] split = tmp.split(" ");
            if(split[0].equals("push")){
                stack.push(Integer.parseInt(split[1]));
            }
            if(split[0].equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
                stack.pop();
            }
            if(split[0].equals("size")){
                System.out.println(stack.size());
            }
            if(split[0].equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            if(split[0].equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
            }
        }
    }
}