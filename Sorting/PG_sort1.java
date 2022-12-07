package Sorting;

import java.util.ArrayList;
import java.util.Collections;

class PG_sort1 {
    public static void main(String[] args) {
        int ary[]={1, 5, 2, 6, 3, 7, 4};
        int commands[][]={{2,5,3}, {4, 4, 1}, {1, 7, 3}};
        Solution s=new Solution();

        int []result=s.solution(ary, commands);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int i = 0; i < commands.length; i++) {
                ArrayList<Integer> data = new ArrayList<>();
                for (int j = commands[i][0]-1; j <commands[i][1] ; j++) {
                    data.add(array[j]);
                }
                Collections.sort(data);
                answer[i]=data.get(commands[i][2]-1);
            }
            return answer;
        }
    }
}