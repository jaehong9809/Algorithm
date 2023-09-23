package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max=0;

        for (int i = 0; i <= n; i++) {
            Integer tmp= i;
            String string = tmp.toString();
            boolean flag=true;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j)!='7'&&string.charAt(j)!='4'){
                    flag=false;
                }
            }
            if(flag){
                max=tmp;
            }
        }
        System.out.println(max);
    }
}