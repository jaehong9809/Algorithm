package DataStructures;

import java.util.*;

class BJ_1966 {
    static int t;
    static class Pair{
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        t= sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Pair> queue = new LinkedList<>();

            int n ,m;
            n= sc.nextInt();
            m= sc.nextInt();
            for (int i = 0; i < n; i++) {
                int tmp= sc.nextInt();
                queue.offer(new Pair(i, tmp));
                pq.offer(tmp);
            }
            int cnt=0;
            while (!queue.isEmpty()){

                Pair pair=queue.poll();
                if(pq.peek()==pair.value){
                    cnt++;
                    if(pair.index==m){
                        break;
                    }
                    int out=pq.poll();
                }else{
                    queue.offer(pair);
                }
            }
            System.out.println(cnt);

        }

    }
}