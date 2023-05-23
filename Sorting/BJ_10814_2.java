package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_10814_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        ArrayList<Pair> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str=sc.nextLine();
            String[] split = str.split(" ");
            data.add(new Pair(Integer.parseInt(split[0]), split[1], i));
        }
        Collections.sort(data);
        for (Pair datum : data) {
            System.out.println(datum.x+" "+datum.y);
        }
    }
    static class Pair implements Comparable<Pair>{
        public int x;
        public String y;
        public int z;
        public Pair(int x, String y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }

        @Override
        public int compareTo(Pair o) {
            if(o.x==this.x){
                return this.z-o.z;
            }
            return this.x-o.x;
        }
    }
}