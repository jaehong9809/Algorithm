package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1697 {
    static int n, k;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        k= sc.nextInt();
        check=new int[100000+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        check[n]=0;
        if(n==k){
            System.out.println(0);
            return;
        }
        while (!queue.isEmpty()){
            int now= queue.poll();
            for (int i = 0; i < 3; i++) {
                int next=0;
                if(i==0){
                    next=now-1;
                }else if(i==1){
                    next=now+1;
                }else{
                    next=now*2;
                }
                if(next==k){
                    check[next]=check[now]+1;
                    System.out.println(check[k]);
                    return;
                }
                if(next>=0&&next<100001){
                    if(check[next]==0){
                        queue.offer(next);
                        check[next]=check[now]+1;
                    }
                }
            }
        }
    }
}