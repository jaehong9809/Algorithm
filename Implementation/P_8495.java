package Implementation;

import java.util.Scanner;

class P_8495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        if (n==1){
            System.out.println(sc.nextInt());
            return;
        }

        int b=2;
        while (b<n){
            b*=2;
        }

        int[] data = new int[b * 2 + 1];
        for (int i = b; i < b + n; i++) {
            data[i]=sc.nextInt();
        }
        int tmp=2;
        for (int i = b/2; i >=1 ; i--) {
            data[i/2]+=data[i];
        }

        for (int i = 1; i <b*2 ; i++) {
            System.out.println(data[i]+" ");
            if(tmp-1==i){
                System.out.println();
                tmp*=2;
            }
        }
    }
}