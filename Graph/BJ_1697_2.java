package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1697_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        if(n==m){
            System.out.println(0);
            return;
        }
        int[] data = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (now * 2 <= 100000) {
                if (now*2 == m) {
                    System.out.println(data[now]+1);
                    return;
                }
                if(data[now*2]==0&&now*2!=0){
                    q.offer(now * 2);
                    data[now * 2] = data[now] + 1;
                }
            }
            if (now - 1 >= 0) {
                if(now-1==m){
                    System.out.println(data[now]+1);
                    return;
                }
                if(data[now-1]==0){
                    q.offer(now - 1);
                    data[now - 1] = data[now] + 1;
                }
            }
            if (now + 1 <= 100000) {
                if(now+1==m){
                    System.out.println(data[now]+1);
                    return;
                }
                if(data[now+1]==0){
                    q.offer(now + 1);
                    data[now + 1] = data[now] + 1;
                }
            }






        }
        System.out.println(data[m]);
    }
}