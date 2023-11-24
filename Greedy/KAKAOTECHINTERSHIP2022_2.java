package Greedy;

import java.util.LinkedList;
import java.util.Queue;

class KAKAOTECHINTERSHIP2022_2 {
   /* public static void main(String[] args) {
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};
        int[] qq1 = {1, 2, 1, 2};
        int[] qq2 = {1, 10, 1, 2};
        int[] qqq1 = {1, 1};
        int[] qqq2 = {1, 5};
        System.out.println(solution(qqq1, qqq2));
    }*/

    static public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i : queue1) {
            q1Sum += (long) i;
            q1.add(i);
        }
        for (int i : queue2) {
            q2Sum += i;
            q2.add(i);
        }

        int cnt=0;
        while (q1Sum!=q2Sum){
            if(cnt>queue1.length*4){
                return -1;
            }
            if(q1Sum>q2Sum){
                Integer poll = q1.poll();
                q2.add(poll);
                q1Sum-=(long)poll;
                q2Sum+=(long)poll;
            }
            else if(q1Sum<q2Sum){
                Integer poll = q2.poll();
                q1.add(poll);
                q2Sum-=(long)poll;
                q1Sum+=(long)poll;
            }

            cnt++;
        }


        int answer = cnt;
        return answer;
    }
}