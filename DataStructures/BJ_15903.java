package DataStructures;

import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m= sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }

        for (int i = 0; i <m ; i++) {
            Long a=pq.poll();
            Long b=pq.poll();
            pq.offer(a+b);
            pq.offer(a+b);
        }
        long result=0;
        while (!pq.isEmpty()) {
            result+=pq.poll();
        }
        System.out.println(result);
    }
}