package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_12851 {
    static int n, k;
    static int[] load = new int[100001];
    static int[] cnt = new int[100001];
    static int min = 100000000;
    static boolean firstsign = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
//        if(n >= k) {
//            System.out.println(n-k);
//            System.out.println(1);
//            return;
//        }
        int bfs = bfs();
        System.out.println(load[k]);
        System.out.println(cnt[k]);
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if(min<load[now]){
                break;
            }
            int next = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = now -1;
                }
                if (i == 1) {
                    next = now + 1;
                }
                if (i == 2) {
                    next = now *2;
                }
                if (next >= 0 && next <= 100000) {
                    if (next == k &&!firstsign) {
                        firstsign=true;
                        min = load[now]+1;
                    }

                    if(next == k && firstsign && load[now]+1 ==min){
                        cnt[next]++;
                        load[next]=min;
                        continue;
                    }
                    if(load[next]==0){
                        queue.offer(next);
                        load[next] = load[now]+1;
                    }
                    else{
                        if (load[next] == load[now] + 1) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return cnt[k];
    }


}