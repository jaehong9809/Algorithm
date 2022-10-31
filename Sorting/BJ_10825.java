package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class BJ_10825 {
    static class Studet implements Comparable<Studet>{
        public String name;
        public int gook;
        public int english;
        public int math;
        public Studet(String name, int gook, int english, int math){
            this.name=name;
            this.gook=gook;
            this.english=english;
            this.math=math;
        }

        @Override
        public int compareTo(Studet o) {
            if(o.gook==this.gook){
                if(o.english==this.english){
                    if(o.math==this.math){
                        return this.name.compareTo(o.name);
                    }
                    return o.math-this.math;
                }
                return this.english-o.english;
            }
            return o.gook-this.gook;
        }
    }
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Studet> arrayList = new ArrayList<>();
        n=Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s=br.readLine();
            StringTokenizer  st=new StringTokenizer(s);
            String name=st.nextToken();
            int gook=Integer.parseInt(st.nextToken());
            int english=Integer.parseInt(st.nextToken());
            int math=Integer.parseInt(st.nextToken());
            arrayList.add(new Studet(name, gook, english, math));
        }
        Collections.sort(arrayList);
        for (Studet studet : arrayList) {
            System.out.println(studet.name);
        }
    }
}