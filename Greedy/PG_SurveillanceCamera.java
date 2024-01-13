package Greedy;

import java.util.Arrays;

class PG_SurveillanceCamera {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> {return a[1]-b[1];});
        int now=routes[0][1];

        for(int i=1; i<routes.length; i++){
            if(now<routes[i][0]){
                answer++;
                now=routes[i][1];
            }
        }

        return answer;
    }
}