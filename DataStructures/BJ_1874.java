package DataStructures;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> data = new LinkedList<>();
        int[] data2=new int[n];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        /*for (int i = 1; i <= n ; i++) {
            queue.offer(i);
        }*/

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            data.offer(a);
            data2[i]=a;
        }
        int cnt=1;
        int index=0;
        // 1 2 3 4 5 6 7 8
        // 8 7 6 5 4 3 2 1
        while (index<n){
            int now=data2[index];
            if(stack.isEmpty()){
                stack.push(cnt++);
                sb.append("+\n");
                continue;
            }
            if ( now < stack.peek()) {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
            if( now==stack.peek()){
                stack.pop();
                sb.append("-\n");
                index++;
                continue;
            }
            if ( now > stack.peek()) {
                stack.push(cnt++);
                sb.append("+\n");
            }
        }
        /*while (!data.isEmpty()) {
            if(stack.isEmpty()){
                stack.push(cnt++);
                sb.append("+\n");
                continue;
            }
            if ( data.peek() < stack.peek()) {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
            if( data.peek()==stack.peek()){
                stack.pop();
                data.poll();
                sb.append("-\n");
                continue;
            }
            // stack =3 , peek = 2

            // stack=3; peek=4
            if ( data.peek() > stack.peek()) {
                stack.push(cnt++);
                sb.append("+\n");
            }
        }*/
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}