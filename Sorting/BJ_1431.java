package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class BJ_1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();

        ArrayList<String > arrayList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextLine());
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    int a=0;
                    int b=0;
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i)-'0'>=0&&o1.charAt(i)-'0'<10){
                            a+=o1.charAt(i)-'0';
                        }
                        if(o2.charAt(i)-'0'>=0&&o2.charAt(i)-'0'<10){
                            b+=o2.charAt(i)-'0';
                        }
                    }
                    if(a==b){
                        return o1.compareTo(o2);
                    }

                    return a-b;
                }
                return o1.length()-o2.length();
            }
        });
        for (String s : arrayList) {
            System.out.println(s);
        }

    }
}