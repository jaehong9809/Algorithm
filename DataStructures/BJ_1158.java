package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_1158 {
    static int n, k;
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n= sc.nextInt();
        k= sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            queue.offer(i);
        }
        int cnt=0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            cnt++;
            if(cnt==k){
                cnt=0;
                list.add(queue.poll());
            }else{
                queue.offer(queue.poll());
            }
        }
        str.append("<");
        for (int i = 0; i < n; i++) {
            str.append(list.get(i));
            if(i!=n-1){
                str.append(", ");
            }
        }
        str.append(">");
        System.out.println(str);
    }
}