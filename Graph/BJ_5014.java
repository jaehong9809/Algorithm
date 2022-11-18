package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_5014 {
    static int F, S, G, U, D;
    static int[] floors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        floors = new int[F + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        floors[S]=1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(now==G){
                System.out.println(floors[now]-1);
                return;
            }
            if(now+U<=F){
                if(floors[now+U]==0) {
                    floors[now + U] = floors[now] + 1;
                    queue.offer(now + U);
                }
            }
            if(now-D>=1){
                if(floors[now-D]==0){
                    floors[now-D]=floors[now]+1;
                    queue.offer(now-D);
                }
            }
        }
        System.out.println("use the stairs");
    }
}