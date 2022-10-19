package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
    private int start;
    private int end;


    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }


    @Override
    public int compareTo(Pair o) {
        if(o.getEnd()==this.getEnd()){
            return this.getStart()-o.getStart();
        }else{
            return this.getEnd()-o.getEnd();
        }

    }
}
class Main{
    static int n;
    static ArrayList<Pair> arrayList = new ArrayList<>();
    static ArrayList<Pair> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n= scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a, b;
            a= scanner.nextInt();
            b= scanner.nextInt();
            arrayList.add(new Pair(a, b));
        }
        Collections.sort(arrayList);
        int count=0;
        int prev_endtime=0;
        for (int i = 0; i < n; i++) {
            if(prev_endtime<=arrayList.get(i).getStart()){
                prev_endtime=arrayList.get(i).getEnd();
                count++;
            }
        }
        System.out.println(count);

    }
}