package ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class problem3 {
  /* public static void main(String[] args) {
        int[][] dice = {{1,2,3,4,5,6,}, {3,3,3,3,4,4}, {1,3,3,4,4,4,}, {1,1,4,4,5,5}};
       int[][] dices2 = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
        int[] solution = solution(dices2);
        for (int i : solution) {
            System.out.println(i);
        }

    }*/
    static int depth=0;
    static List<String> comb = new ArrayList<>();
    static int arr[];
    static int length=0;
    static boolean[] checked;
    static public int[] solution(int[][] dice) {
        int[] answer = new int[dice.length/2];
        depth=dice.length/2;
        length=dice.length;
        arr=new int[depth];
        checked=new boolean[length+1];
        dfs(0, 0);
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < comb.size(); i++) {
            map.put(comb.get(i), new ArrayList<>());
        }
        for (int i = 0; i <comb.size() ; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    
                }
            }
        }

        /*for (int i = 0; i < dice.length-1; i++) {
            for (int j = i+1; j < dice.length; j++) {
                int[] a=dice[i];
                int[] b=dice[j];
                int aCnt=0;
                int bCnt=0;
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        if(a[k]>b[l]){
                            aCnt++;
                        }
                        if(a[k]<b[l]){
                            bCnt++;
                        }
                    }
                }
                dicesPoint.get(i).y+=aCnt;
                dicesPoint.get(j).y+=bCnt;
            }
        }
        Collections.sort(dicesPoint);
        for (int i = 0; i < dice.length/2; i++) {
            answer[i]=dicesPoint.get(i).x+1;
        }
        Arrays.sort(answer);*/
        return answer;
    }
    static void dfs(int dep, int startnode){
        if(dep==depth){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(arr[i]);
            }
            comb.add(String.valueOf(sb));
            return;
        }

       for(int i=startnode; i<length; i++){
           if(!checked[i]){
               checked[i]=true;
               arr[dep]=i;
               dfs(dep+1, i+1);
               checked[i]=false;
           }
       }
    }
   static class Pair implements Comparable<Pair>{
       public int x;
       public int y;
       public Pair(int x, int y){
           this.x=x;
           this.y=y;
       }

       @Override
       public int compareTo(Pair o) {
           return o.y-this.y;
       }
   }

}