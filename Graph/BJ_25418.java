package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_25418 {
    static int n;
    static int k;
    static int min = 10_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int[] visited=new int[k+1];

        while (!q.isEmpty()) {
            Integer now = q.poll();

            if(now+1<=k){
                if(visited[now+1]==0){
                    visited[now+1]=visited[now]+1;
                    q.offer(now+1);
                }
                else if(visited[now+1]>visited[now]+1){
                    visited[now+1]=visited[now]+1;
                    q.offer(now+1);
                }
            }
            if(now*2<=k){
                if(visited[now*2]==0){
                    visited[now*2]=visited[now]+1;
                    q.offer(now * 2);
                }
                else if(visited[now*2]>visited[now]+1){
                    visited[now*2]=visited[now]+1;
                    q.offer(now * 2);
                }
            }

        }
        return visited[k];
    }
}