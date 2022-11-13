package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

class SWEA_1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            int n= sc.nextInt();
            int cnt=0;
            sc.nextLine();
            String tmp="";
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str= sc.nextLine();
                String[] s = str.split(" ");
                for (int j = 0; j < Integer.parseInt(s[1]); j++) {
                    tmp+=s[0];
                    cnt++;

                    if(cnt==10){
                        cnt=0;
                        list.add(tmp);
                        tmp = "";
                    }
                }
            }
            list.add(tmp);
            System.out.println("#"+(test_case+1));
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}