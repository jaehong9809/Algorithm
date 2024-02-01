package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BJ_1446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m=sc.nextInt();

        int[] load=new int[10001];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        for (int i = 1; i <= m; i++) {
            load[i]=load[i-1]+1;
            for (int j = 0; j < n; j++) {
                if(list.get(j)[1]==i){
                    load[i]=Math.min(load[i], load[list.get(j)[0]]+list.get(j)[2]);
                }
            }
        }

        System.out.println(load[m]);
    }
}