package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BJ_16212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] data=new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(data);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(data[i]).append(" ");
        }
        System.out.println(sb);
    }
}