package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            String sb1 = "";
            String sb2 = "";

            for (int j = 0; j < n; j++) {
                sb1 += Integer.toString(map[i][j]);
                sb2 += Integer.toString(map[j][i]);
            }

            String[] sp1 = sb1.split("1");
            String[] sp2 = sb2.split("1");
            for (String s : sp1) {
                if (s.length() >= 2) a++;
            }
            for (String s : sp2) {
                if (s.length() >= 2) b++;
            }
        }
        System.out.println(a + " " + b);
    }
}