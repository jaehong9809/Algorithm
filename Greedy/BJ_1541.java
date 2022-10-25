package Greedy;

import java.io.*;

class BJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        String[] strings = str.split("-");
        int total=0;
        int cnt=0;
        for (String string : strings) {

            int tmp=0;
            String[] num = string.split("\\+");
            for (String s : num) {
                tmp+=Integer.parseInt(s);
            }
            if(cnt==0){
                total=tmp;
            }else{
                total-=tmp;
            }
            cnt++;
        }
        bw.write(total+"\n");
        bw.flush();
        bw.close();

    }
}