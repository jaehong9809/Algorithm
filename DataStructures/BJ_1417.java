package DataStructures;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class BJ_1417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int user = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            pq.add(sc.nextInt());
        }
        int cnt = 0;
        while (user <= pq.peek()) {
            int top = pq.poll();
            top--;
            pq.offer(top);
            user++;
            cnt++;
        }
        System.out.println(cnt);
    }
}