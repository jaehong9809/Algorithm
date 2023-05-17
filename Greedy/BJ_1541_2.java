package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

class BJ_1541_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] split = str.split("-");
        ArrayList<Integer> data = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split("\\+");
            int cnt=0;
            for (String s1 : split1) {
                cnt+=Integer.parseInt(s1);
            }
            data.add(cnt);
        }
        int result=data.get(0);
        if(data.size()>1){
            for (int i = 1; i < data.size(); i++) {
                result-=data.get(i);
            }
            System.out.println(result);
        }else{
            System.out.println(result);
        }

    }
}