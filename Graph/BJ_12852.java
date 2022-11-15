package Graph;

import java.util.*;

class BJ_12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int visited[]=new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n]=1;
        int path[]=new int[n+1];

        while (!queue.isEmpty()) {
            int now=queue.poll();
            if(now%3==0){
                if(visited[now/3]==0){
                    queue.offer(now/3);
                    visited[now/3]=visited[now]+1;
                    path[now/3]=now;
                }
            }
            if(now%2==0){
                if(visited[now/2]==0){
                    queue.offer(now/2);
                    visited[now/2]=visited[now]+1;
                    path[now/2]=now;
                }
            }
           if(now-1!=0){
               if(visited[now-1]==0){
                   queue.offer(now-1);
                   visited[now-1]=visited[now]+1;
                   path[now-1]=now;

               }
           }
        }
        int nowindex=1;
        ArrayList<Integer> aa = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(path[nowindex]==i){
                aa.add(nowindex);
                nowindex=i;
            }
        }
        aa.add(n);
        System.out.println(visited[1]-1);
        Collections.reverse(aa);
        for (Integer integer : aa) {
            System.out.print(integer+" ");
        }
        System.out.println();
//        System.out.print(n+" ");

    }

}