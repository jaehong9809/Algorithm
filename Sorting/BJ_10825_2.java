package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_10825_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<subject> data = new ArrayList<>();
        int n= sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str=sc.nextLine();
            String[] split = str.split(" ");

            data.add(new subject(Integer.parseInt(split[1]), Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[0]));
        }
        Collections.sort(data);
        for (subject datum : data) {
            System.out.println(datum.name);
        }

    }
    static class subject implements Comparable<subject>{
        public int korean;
        public int english;
        public int math;
        public String name;
        public subject(int korean, int english, int math, String name) {
            this.korean = korean;
            this.english = english;
            this.math = math;
            this.name=name;
        }

        @Override
        public int compareTo(subject o) {
            if(o.korean==this.korean){
                if(this.english==o.english){
                    if(this.math==o.math){
                        return this.name.compareTo(o.name);
                    }

                    return o.math-this.math;
                }

                return this.english-o.english;
            }

            return o.korean-this.korean;
        }
    }
}