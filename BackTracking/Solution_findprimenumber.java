package BackTracking;

import java.util.HashSet;
import java.util.Set;

class Solution_findprimenumber {
    static boolean[] visited = new boolean[8];
    static int len;
    static String[] arr = new String[8];
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        len = numbers.length();
        for (int i = 1; i <= len; i++) {
            dfs(0, i, numbers);
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
        return set.size();
    }

    void dfs(int depth, int max, String numbers) {
        if (depth == max) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(arr[i]);
            }
            int i = Integer.parseInt(sb.toString());
            if (checkPrime(i)) {
                set.add(i);
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers.substring(i, i + 1);
                dfs(depth + 1, max, numbers);
                visited[i] = false;
            }
        }
    }

    public boolean checkPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        if (num == 1 || num == 0) {
            return false;
        }
        return true;
    }
}