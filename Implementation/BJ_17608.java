package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] data=new int[n];
        int max=-1;
        int result=0;

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n-1; i >=0 ; i--) {
            if(max<data[i]) result++;
            if(max<data[i]){
                max=data[i];
            }
        }
        System.out.println(result);

    }
}