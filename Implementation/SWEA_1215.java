package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SWEA_1215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 0; testCase < 10; testCase++) {
            char matrix[][]=new char[8][8];
            int leng= sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < 8; i++) {
                String str= sc.nextLine();
                for (int j = 0; j < 8; j++) {
                    matrix[i][j]=str.charAt(j);
                }
            }

            int cnt=0;
            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < 8-leng+1; j++) {
                    ArrayList<String> ar=new ArrayList<>();
                    String str="";
                    for (int k = j; k <j+leng ; k++) {
                        ar.add(Character.toString(matrix[i][k]));
                        str+=Character.toString(matrix[i][k]);
                    }
                    String reverse = "";
                    Collections.reverse(ar);
                    for (String s : ar) {
                        reverse+=s;
                    }
                    if(str.equals(reverse))cnt++;
                }
            }
            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < 8-leng+1; j++) {
                    ArrayList<String> ar=new ArrayList<>();
                    String str="";
                    for (int k = j; k <j+leng ; k++) {
                        ar.add(Character.toString(matrix[k][i]));
                        str+=Character.toString(matrix[k][i]);
                    }
                    String reverse = "";
                    Collections.reverse(ar);
                    for (String s : ar) {
                        reverse+=s;
                    }
                    if(str.equals(reverse))cnt++;
                }
            }
            System.out.printf("# %d %d\n", testCase+1, cnt);
        }
    }
}