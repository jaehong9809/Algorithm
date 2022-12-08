package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class BJ_4158 {
    static int m, n;
    static int candies[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0&&m==0)break;

            ArrayList<Integer> nlist = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nlist.add(Integer.parseInt(br.readLine()));
            }
            int cnt=0;
            for (int i = 0; i < m; i++) {
                int tmp = Integer.parseInt(br.readLine());
                if(Collections.binarySearch(nlist, tmp)>=0){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}