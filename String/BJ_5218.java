package String;

import java.util.Scanner;
import java.util.StringTokenizer;

class BJ_5218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        sc.nextLine();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            String tmp=sc.nextLine();
            StringTokenizer st=new StringTokenizer(tmp);
            String a=st.nextToken();
            String b=st.nextToken();
            System.out.print("Distances: ");
            for (int i = 0; i < a.length(); i++) {
                int gap=0;
                if(b.charAt(i)>=a.charAt(i))gap=b.charAt(i)-a.charAt(i);
                else{
                    gap=b.charAt(i)+26-a.charAt(i);
                }
                System.out.print(gap+" ");
            }
            System.out.println();
        }
    }
}