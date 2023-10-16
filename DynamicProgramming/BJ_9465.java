package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            simul(br);
        }
    }

    private static void simul(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] pictures = new int[2][n];
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");
        int[][] d = new int[2][n];
        for (int i = 0; i < n; i++) {
            pictures[0][i] = Integer.parseInt(first[i]);
            pictures[1][i] = Integer.parseInt(second[i]);
        }
        if(n==1){
            System.out.println(Math.max(pictures[0][0], pictures[1][0]));
            return;
        }
        if(n==2){
            System.out.println(Math.max(pictures[0][0]+pictures[1][1], pictures[0][1]+pictures[1][0]));
            return;
        }
        d[0][0] = pictures[0][0];
        d[1][0] = pictures[1][0];

        d[0][1] = pictures[1][0] + pictures[0][1];
        d[1][1] = pictures[0][0] + pictures[1][1];
        for (int i = 2; i < n; i++) {
            d[0][i] = Math.max(d[1][i - 1], d[1][i - 2]) + pictures[0][i];
            d[1][i] = Math.max(d[0][i - 1], d[0][i - 2]) + pictures[1][i];
        }
        System.out.println(Math.max(d[0][n - 1], d[1][n - 1]));
    }
}