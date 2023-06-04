package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class BJ_11004 {
    static int n;
    static int k;
    static ArrayList<Integer> data = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] s1 = s.split(" ");
        n= Integer.parseInt(s1[0]);
        k= Integer.parseInt(s1[1]);
        String s2 = bufferedReader.readLine();
        String[] s3 = s2.split(" ");
        for (int i = 0; i < s3.length; i++) {
            data.add(Integer.parseInt(s3[i]));
        }
        Collections.sort(data);

        System.out.println(data.get(k-1));
    }
}