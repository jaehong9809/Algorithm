package Greedy;

import java.util.Arrays;

class Solution_healthclothes {

    public int solution(int n, int[] lost, int[] reserve){
        int[] students=new int[n+2];

        Arrays.fill(students, 1);

        for (int i : lost) {
            students[i]--;
        }

        for (int i : reserve) {
            students[i]++;
        }

        for (int i = 1; i <=n ; i++) {
            if(students[i]==0){
                if(students[i-1]>=2){
                    students[i-1]--;
                    students[i]++;
                    continue;
                }
                if(students[i+1]>=2){
                    students[i+1]--;
                    students[i]++;
                }
            }
        }

        int answer=0;

        for (int i = 1; i <=n ; i++) {
            if(students[i]>=1){
                answer++;
            }
        }

        return answer;
    }
}