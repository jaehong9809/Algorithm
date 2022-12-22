package String;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class BJ_1755 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m= sc.nextInt();
        int n= sc.nextInt();
        LinkedList<Pair> data = new LinkedList<>();
        String[] strings=new String[10];
        strings[0]="zero";
        strings[1]="one";
        strings[2]="two";
        strings[3]="three";
        strings[4]="four";
        strings[5]="five";
        strings[6]="six";
        strings[7]="seven";
        strings[8]="eight";
        strings[9]="nine";
        for (int i = m; i <=n ; i++) {
            String str=Integer.toString(i);
            String tmp="";
            for (int j = 0; j < str.length(); j++) {
                tmp+=strings[Integer.parseInt(str.substring(j, j+1))]+" ";
            }
            data.add(new Pair(tmp, i));
        }
        Collections.sort(data);


        int cnt=0;
        while (data.size()>0){
            cnt++;
            System.out.print(data.get(0).realnumber+" ");
            if(cnt==10){
                System.out.println();
                cnt=0;
            }
            data.remove(0);
        }
    }
    static class Pair implements Comparable<Pair> {
        String number;
        int realnumber;

        public Pair(String number, int realnumber) {
            this.number = number;
            this.realnumber = realnumber;
        }

        @Override
        public int compareTo(Pair o) {
            return this.number.compareTo(o.number);
        }
    }
}