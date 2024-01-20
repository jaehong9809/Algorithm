package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_13549 {
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(n, 0));
        boolean[] visited=new boolean[100001];

        while (!q.isEmpty()) {
            Pair now = q.poll();
            visited[now.x]=true;
            if(now.x==k){
                min=Math.min(min, now.y);
            }
            if(now.x*2<=100000&&!visited[now.x*2]){
                q.offer(new Pair(now.x*2, now.y ));
            }
            if(now.x+1<=100000&&!visited[now.x+1]){
                q.offer(new Pair(now.x+1, now.y + 1));
            }
            if(now.x-1>=0&&!visited[now.x-1]){
                q.offer(new Pair(now.x-1, now.y + 1));
            }
        }


        System.out.println(min);
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