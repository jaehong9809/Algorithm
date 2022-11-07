package Sorting;

import java.util.ArrayList;
import java.util.Collections;

class KAKAO_2019_실패율 {
     public static void main(String[] args) {
         int n=5;
         int[] stages= {2, 1, 2, 6, 2, 4, 3, 3};
         int[] result = solution(n,stages);
         for (int i : result) {
             System.out.print(i+" ");
         }
     }
     static public int[] solution(int N, int[] stages) {
         int[] answer = new int[N+2];

         for (int i = 0; i < stages.length; i++) {
            answer[stages[i]]++;
         }
         ArrayList<Pair> list = new ArrayList<>();
         int total=stages.length;
         for (int i = 1; i <=N ; i++) {
             total-=answer[i-1];
             list.add(new Pair(i, answer[i]/(double)total));
         }
         Collections.sort(list);
         int result[]=new int[N];
         for (int i = 0; i < N; i++) {
             result[i]=list.get(i).stage;
         }
         return result;
     }
     static class Pair implements Comparable<Pair>{
         int stage;
         double fail;

         public Pair(int stage, double fail) {
             this.stage = stage;
             this.fail = fail;
         }

         @Override
         public int compareTo(Pair o) {
             if(o.fail==this.fail){
                 return this.stage-o.stage;
             }
             double tmp=o.fail-this.fail;
             int comp=0;
             if(tmp>0){
                 comp=1;
             }
             if(tmp<0){
                 comp=-1;
             }
             return comp;
         }
     }
 }