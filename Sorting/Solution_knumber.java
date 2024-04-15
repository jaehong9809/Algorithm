package Sorting;

import java.util.ArrayList;
import java.util.Collections;

class Solution_knumber {
       public int[] solution(int[] array, int[][] commands){

        int comLen = commands.length;
        int[] answer = new int[comLen];
        for (int i = 0; i < comLen; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];
            ArrayList<Integer> tmpArray = new ArrayList<>();
            for (int j = start; j <= end ; j++) {
                tmpArray.add(array[j-1]);
            }
            Collections.sort(tmpArray);
            answer[i] = tmpArray.get(index-1);
        }
        return answer;
    }
}