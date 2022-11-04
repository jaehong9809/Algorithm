package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_1120 {
    static String A;
    static String B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        A = st.nextToken();
        B = st.nextToken();

        if (A.length() == B.length()) {
            int cnt = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) cnt++;
            }
            System.out.println(cnt);
            return;
        }
        int min = 1000;
        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (B.charAt(j + i) == A.charAt(j)) {
                    cnt++;
                }
            }
            if (min > (A.length() - cnt)) {
                min = A.length() - cnt;
            }
        }
        System.out.println(min);
    }
}