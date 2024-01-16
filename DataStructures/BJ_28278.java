package DataStructures;

import java.io.*;
import java.util.Stack;

class BJ_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> st = new Stack<>();
        int n= Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            int com=str.charAt(0)-'0';
            if(com==1){
                String[] s = str.split(" ");
                st.push(Integer.parseInt(s[1]));
            }
            if (com==2){
                if(st.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    Integer pop = st.pop();
                    bw.write(pop+"\n");
                }
            }
            if (com==3){
                bw.write(st.size()+"\n");
            }if(com==4){
                if(st.isEmpty()){
                    bw.write(1+"\n");
                }else bw.write(0+"\n");
            }
            if(com==5){
                if(st.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(st.peek()+"\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}