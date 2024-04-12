package DataStructures;

import java.util.PriorityQueue;

class Solution_morehot {


    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int zerocnt=0;
        for (int i : scoville) {
            queue.offer((long) i);
            if(i==0)zerocnt++;
        }
        if(zerocnt>1){
            return -1;
        }
        while (true) {
            boolean sign = true;
            for (Long i : queue) {
                if (i < K) {
                    sign = false;
                    break;
                }
            }

            if (sign) {
                break;
            } else {
                Long worst = queue.poll();
                Long second_worst = queue.poll();

                queue.offer((second_worst) * 2 + worst);
                answer++;

                if (queue.size()<=1){
                    if (queue.peek()<K){
                        return -1;
                    }
                }
            }
        }
        return answer;
    }
}