package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i%2==0){
                    if(j%2==0){
                        if(matrix[i][j]=='F')cnt++;
                    }
                }
                else{
                    if(j%2==1){
                        if(matrix[i][j]=='F')cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}