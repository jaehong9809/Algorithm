package DataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class BJ_2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<int[]> deque = new ArrayDeque<>();

        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            deque.offerLast(new int[]{i+1, sc.nextInt()});
        }

        while (!deque.isEmpty()){
            int[] now = deque.pollFirst();
            System.out.print(now[0]+" ");
            if(deque.isEmpty())break;
            if(now[1]<0){
                for (int i = 0; i < Math.abs(now[1]); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }else{
                for (int i = 0; i < now[1]-1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
        }
    }
}