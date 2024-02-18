package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class BJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            String[] strings = str.split("\\.");

            map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
        }

        for (String s : map.keySet()) {
            System.out.println(s+" "+map.get(s));
        }
    }
}