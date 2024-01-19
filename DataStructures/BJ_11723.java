package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set=new TreeSet<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            if (str[0].equals("add")) {
                set.add(Integer.parseInt(str[1]));
            }

            if (str[0].equals("remove")) {
                set.remove(Integer.parseInt(str[1]));
            }

            if (str[0].equals("check")) {
                if (set.contains(Integer.parseInt(str[1]))) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }

            if (str[0].equals("toggle")) {
                if (set.contains(Integer.parseInt(str[1]))) {
                    set.remove(Integer.parseInt(str[1]));
                }else{
                    set.add(Integer.parseInt(str[1]));
                }
            }

            if (str[0].equals("all")) {
                set.clear();
                set = new TreeSet<>(list);
            }

            if (str[0].equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}