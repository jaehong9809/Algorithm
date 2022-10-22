package Implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class BJ_1065 {
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n= sc.nextInt();
        int cnt=0;
        for (int i = 1; i <= n; i++) {
            String str=Integer.toString(i);
            Set<Integer> set=new HashSet<>();
            if(str.length()==1){
                cnt++;
                continue;
            }
            for (int j = 0; j < str.length()-1; j++) {
                set.add(str.charAt(j+1)-str.charAt(j));
            }
            if (set.size()==1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}