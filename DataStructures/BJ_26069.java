package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

class BJ_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>();
        boolean startSign = false;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("ChongChong") || s[1].equals("ChongChong")) {
                startSign = true;
                set.add(s[0]);
                set.add(s[1]);
            }

            if (startSign) {
                if (set.contains(s[0])) {
                    set.add(s[1]);
                }

                if (set.contains(s[1])) {
                    set.add(s[0]);
                }
            }
        }

        System.out.println(set.size());

    }
}