package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = (Integer.parseInt(br.readLine())/100)*100;

        int f = Integer.parseInt(br.readLine());
        int init=n;
        while (true){
            if(n%f==0)break;
            n++;
        }
        String string = Integer.valueOf(n - init).toString();
        String result=string;
        if(string.length()==1){
            result="0"+string;
        }
        System.out.println(result);


    }
}