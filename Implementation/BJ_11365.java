package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String a=br.readLine();
            StringBuilder str = new StringBuilder();
            str.append(a);

            if(a.equals("END"))break;
            System.out.println(str.reverse());
        }
    }
}