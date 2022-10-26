package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class BJ_14425 {
    static Set<String> set = new HashSet<>();
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }
        int cnt=0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(set.contains(str))cnt++;
        }
        System.out.println(cnt);
    }
}