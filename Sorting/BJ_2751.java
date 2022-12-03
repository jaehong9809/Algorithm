package Sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class BJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arrayList);
        for (Integer integer : arrayList) {
            bw.write(integer+"\n");
        }
        bw.flush();
        bw.close();
    }
}