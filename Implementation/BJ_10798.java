package Implementation;

import java.util.Arrays;
import java.util.Scanner;

class BJ_10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] words=new char[5][15];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(words[i], '-');
        }
        int maxLength=0;
        for (int i = 0; i <5 ; i++) {
            String s = sc.nextLine();
            if (maxLength < s.length()) {
                maxLength = s.length();
            }
            for (int j = 0; j < s.length(); j++) {
                words[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if(words[j][i]!='-') System.out.print(words[j][i]);
            }
        }
    }
}