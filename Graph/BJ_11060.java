package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_11060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        int map[]=new int[n+1];
        int d[]=new int[n+1];
        for (int i = 1; i <= n; i++) {
            map[i]=sc.nextInt();
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()){
            int now=queue.poll();
            for (int i = 1; i <= map[now] ; i++) {
               if(now+i<=n){
                   if(d[now+i]==0){
                       d[now+i]=d[now]+1;
                       queue.offer(now+i);
                   }
               }
            }
        }
        if(d[n]==0){
            System.out.println(-1);
        }else{
            System.out.println(d[n]);
        }
    }
}