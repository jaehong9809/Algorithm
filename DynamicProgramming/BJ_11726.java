package DynamicProgramming;

import java.util.Scanner;

class BJ_11726 {
    //문제이상함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] list = new long[1000 + 1];
        list[1] = 1;
        list[2] = 2;
        list[3] = 3;
        if(n<=3){
            System.out.println(list[n]);
            return;
        }
        for (int i = 3; i <= n; i++) {
            list[i] = (list[i - 1] + list[i - 2])%10007;

        }
        System.out.println(list[n]%10007);
    }
}