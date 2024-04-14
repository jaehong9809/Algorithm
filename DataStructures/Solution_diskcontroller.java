package DataStructures;

import java.util.*;

class Solution_diskcontroller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println(solution(jobs));
    }

    static public int solution(int[][] jobs) {
        int answer = 0;
        int time=0;
        Queue<Jobs> q = new LinkedList<>();
        Arrays.sort(jobs, (a, b)->{
            if (a[0] == b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        PriorityQueue<Jobs> pq = new PriorityQueue<>();
        for (int i = 0; i < jobs.length; i++) {
            q.offer(new Jobs(jobs[i][0], jobs[i][1]));
        }
        ArrayList<Integer> result = new ArrayList<>();

        boolean workingsign = false;
        int endtime=0;
        int starttime=0;
        int workedCnt =0;
        while (workedCnt !=  jobs.length) {
            if (!q.isEmpty()) {
                if (q.peek().start == time) {
                    while (!q.isEmpty()&&q.peek().start == time) {
                        pq.offer(q.poll());
                    }
                }
            }

            if(!workingsign){
                if (!pq.isEmpty()) {
                    Jobs poll = pq.poll();
                    endtime = time+ poll.time;
                    starttime = poll.start;
                    workingsign=true;
                }
            }
            if (workingsign && (endtime == time)) {
                workingsign=false;
                result.add(endtime - starttime);
                workedCnt++;
            }
            if(!workingsign){
                if (!pq.isEmpty()) {
                    Jobs poll = pq.poll();
                    endtime = time+ poll.time;
                    starttime = poll.start;
                    workingsign=true;
                }
            }
            time++;
        }
        int total = 0;
        for (Integer integer : result) {
            total+=integer;
        }
        answer = total / result.size();
        return answer;
    }


    static class Jobs implements Comparable<Jobs>{
        int start;
        int time;

        public Jobs(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Jobs o) {
            if(this.time== o.time){
                return this.start - o.start;
            }
            return this.time- o.time;
        }
    }
}