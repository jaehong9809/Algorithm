package DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class BJ_1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        String str=sc.nextLine();

        Map<Character, Double> map = new HashMap<>();
        int start=(int)'A';
        for (int i = 0; i < n; i++) {
            map.put((char) start++, sc.nextDouble());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char w = str.charAt(i);
            if ((int) w >= (int) 'A' && (int) w <= (int) 'Z') {
                stack.push(map.get(w));
            }
            else{
                double a=stack.pop();
                double b=stack.pop();
                double res=0.0;
                if(w=='+'){
                    res=a+b;
                } else if (w=='-'){
                    res=b-a;
                } else if (w == '*') {
                    res=a*b;
                }else if(w=='/'){
                    res=b/a;
                }

                stack.push(res);
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}