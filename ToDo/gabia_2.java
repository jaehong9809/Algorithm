package ToDo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class gabia_2 {
  /* public static void main(String[] args) {
        int[][] fees = {{4, 1000}, {6, 1000}, {21, 3000}, {16, 2000}, {26, 3000}};
        int[][] fees2={{3, 40000}, {5, 60000}};
        int[][] fees3={{1, 1000}};
        int t= 27;
        long[] solution = solution(fees3, 10);
        System.out.println(Arrays.toString(solution));
    }*/
   public long[] solution(int[][] fees, int t) {
        long[] answer;
        List<Long> values = new ArrayList<>();
        int max=-1;
        for (int i = 0; i < fees.length ; i++) {
           if(max<fees[i][0]){
               max=fees[i][0];
           }
        }
        for (int i = 1; i <= max ; i++) {
            boolean isA=true;
            int a=i;
            int tmpA=fees[0][0]/a;
            int b=0;
            if(tmpA==0){
                b=fees[0][1];
            }else{
                b=fees[0][1]/(tmpA+1);
            }
            for (int j = 1; j < fees.length; j++) {
                if(fees[j][1]!=(b+(b*(fees[j][0]/a)))){
                    isA=false;
                    break;
                }
            }
            if(isA){
                values.add((long) (b+ (long) (t / a) *b));
            }
        }
        if(values.isEmpty()){
            answer=new long[1];
            answer[0]=-1;
        }else{
            answer=new long[2];
            answer[0] = Collections.min(values);
            answer[1]=Collections.max(values);
        }
        return answer;
    }
}