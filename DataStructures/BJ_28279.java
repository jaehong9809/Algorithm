package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class BJ_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int sign = Integer.parseInt(s[0]);

            if(sign==1){
                deque.offerFirst(Integer.parseInt(s[1]));
            } else if (sign==2) {
                deque.offerLast(Integer.parseInt(s[1]));
            }else if (sign==3) {
                if(deque.isEmpty()) sb.append("-1\n");
                else{
                    sb.append(deque.pollFirst()).append("\n");
                }
            }else if (sign==4) {
                if(deque.isEmpty()) sb.append("-1\n");
                else{
                    sb.append(deque.pollLast()).append("\n");
                }
            }else if (sign==5) {
                sb.append(deque.size()).append("\n");
            }else if (sign==6) {
                if (deque.isEmpty()) {
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }else if (sign==7) {
                if(deque.isEmpty()) sb.append("-1\n");
                else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }else if (sign==8) {
                if(deque.isEmpty()) sb.append("-1\n");
                else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}