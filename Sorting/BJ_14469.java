package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BJ_14469 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Cow> cows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cows.add(new Cow(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(cows);

        int endTime=0;
        for (int i = 0; i < n; i++) {
            if(endTime<cows.get(i).start){
                endTime=cows.get(i).start+cows.get(i).time;
            }
            else{
                endTime+=cows.get(i).time;
            }
        }
        System.out.println(endTime);
    }

    static class Cow implements Comparable<Cow> {
        int start;
        int time;

        public Cow(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Cow o) {
            return this.start - o.start;
        }
    }
}