package Greedy;

import java.util.Scanner;

class BJ_4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=0;
        while (true){
            t++;
            int l= sc.nextInt();
            int p= sc.nextInt();
            int v= sc.nextInt();
            if(l==0&&p==0&&v==0)break;
            int result=(v/p)*l;
            if(v%p>l){
                result+=l;
            }else{
                result+=v%p;
            }
            System.out.println("Case "+t+": "+result);
        }
    }
}