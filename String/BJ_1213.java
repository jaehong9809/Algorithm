package String;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class BJ_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String, Integer> map = new TreeMap<>();
        int odd = 0;
        int even = 0;
        for (int i = 0; i < str.length(); i++) {
            String tmp = str.substring(i, i + 1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (value % 2 == 0) even++;
            else odd++;
        }
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        } else if (odd == 1) {
            String oddNumber = "";
            for (String s : map.keySet()) {
                if (map.get(s) % 2 != 0) {
                    oddNumber = s;
                    map.put(s, map.get(s) - 1);
                    break;
                }
            }
            String tmp = "";
            for (String s : map.keySet()) {
                for (int i = 1; i <= map.get(s) / 2; i++) {
                    tmp += s;
                }
            }

            StringBuffer sb = new StringBuffer(tmp);
            tmp += (oddNumber) + sb.reverse().toString();
            System.out.println(tmp);
        } else if (odd == 0) {
            String tmp = "";
            for (String s : map.keySet()) {
                for (int i = 1; i <= map.get(s) / 2; i++) {
                    tmp += s;
                }
            }
            StringBuffer sb = new StringBuffer(tmp);
            tmp += sb.reverse().toString();
            System.out.println(tmp);
        }
    }
}