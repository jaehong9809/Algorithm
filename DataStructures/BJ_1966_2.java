package DataStructures;

import java.util.*;

class BJ_1966_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int n= sc.nextInt();
            int m= sc.nextInt();
            Queue<Pair> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                int b= sc.nextInt();
                queue.offer(new Pair(i, b));
                priorityQueue.offer(b);
            }
            int cnt=0;

            while (!queue.isEmpty()){
                if(queue.peek().y==priorityQueue.peek()){
                    Pair e=queue.poll();
                    priorityQueue.poll();
                    cnt++;
                    if(e.x==m){
                        break;
                    }

                }else{
                    queue.offer(queue.poll());
                }


            }
            System.out.println(cnt);
        }
    }
    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}