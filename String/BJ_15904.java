package String;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_15904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i)>=(int)'A' && (int)str.charAt(i)<=(int)'Z'){
                sb.append(str.charAt(i));
            }
        }
        Queue<Character> q = new LinkedList<>();
        q.offer('U');
        q.offer('C');
        q.offer('P');
        q.offer('C');

        for (int i = 0; i < sb.length(); i++) {
            if(q.isEmpty()) break;

            if(q.peek().equals(sb.charAt(i))){
                q.poll();
            }
        }

        if(q.isEmpty()) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
    }
}